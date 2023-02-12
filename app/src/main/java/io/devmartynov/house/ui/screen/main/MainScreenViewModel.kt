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
import java.text.SimpleDateFormat
import java.util.*

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
                        val date1 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.UK)
                            .parse(result.value)
                        val date = SimpleDateFormat("dd.MM.yyyy").format(date1)

                        uiState.value = uiState.value.copy(
                            status = ActionStatus.Success,
                            gasDate = date,
                            waterDate = date,
                            electricityDate = date
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