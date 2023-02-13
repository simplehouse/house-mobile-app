package io.devmartynov.house.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.devmartynov.house.domain.useCase.GetMeterReadingDateUseCase
import io.devmartynov.house.ui.screen.main.model.MainScreenEvent
import io.devmartynov.house.ui.screen.main.model.MainScreenState
import io.devmartynov.house.app.model.ActionStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import io.devmartynov.house.app.model.Result
import io.devmartynov.house.domain.model.Service
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Вью модель главного экрана
 */
@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getMeterReadingDateUseCase: GetMeterReadingDateUseCase,
) : ViewModel() {
    val uiState = MutableStateFlow(MainScreenState())

    init {
        loadServicesDates()
    }

    /**
     * Обработка события на главном экране
     * @param event событие на главном экране
     */
    fun handleEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.DataRefreshed -> {
                loadServicesDates()
            }
        }
    }

    /**
     * Прошла ли дата внесения показания счетчика
     *
     * @param service коммунальная услуга
     * @return true если дата прошла иначе false
     */
    fun isSubmissionDateExpired(service: Service): Boolean {
        val submissionDate = Date()

        when (service) {
            Service.GAS -> {
                submissionDate.time = uiState.value.gasDate ?: 0
            }
            Service.WATER -> {
                submissionDate.time = uiState.value.waterDate ?: 0
            }
            Service.ELECTRICITY -> {
                submissionDate.time = uiState.value.electricityDate ?: 0
            }
        }
        return Date().after(submissionDate)
    }

    /**
     * Кол-во дней до истечения дата внесения показания счетчика
     *
     * @param service коммунальная услуга
     *
     * @return кол-во дней
     */
    fun getDaysUntilSubmissionDateExpiration(service: Service): Int {
        val then = Date()

        when (service) {
            Service.GAS -> {
                then.time = uiState.value.gasDate ?: 0
            }
            Service.WATER -> {
                then.time = uiState.value.waterDate ?: 0
            }
            Service.ELECTRICITY -> {
                then.time = uiState.value.electricityDate ?: 0
            }
        }

        val now = Date()
        val diff = then.time - now.time

        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS).toInt()
    }

    /**
     * Получает даты подачи показаний
     *
     * @param isInitialRequest начальная загрузка или нет
     */
    private fun loadServicesDates(isInitialRequest: Boolean = false) {
        uiState.value = uiState.value.copy(
            status = if (isInitialRequest) {
                ActionStatus.Loading
            } else {
                ActionStatus.Refreshing
            }
        )

        viewModelScope.launch(Dispatchers.IO) {
            val result = getMeterReadingDateUseCase()

            withContext(Dispatchers.Main) {
                when (result) {
                    is Result.Success -> {
                        uiState.value = uiState.value.copy(
                            status = ActionStatus.Success,
                            gasDate = result.value,
                            waterDate = result.value,
                            electricityDate = result.value,
                        )
                    }
                    is Result.Failure -> {
                        // todo show notification
                    }
                }
            }
        }
    }
}