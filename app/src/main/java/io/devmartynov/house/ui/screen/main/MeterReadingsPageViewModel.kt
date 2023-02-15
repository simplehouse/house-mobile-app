package io.devmartynov.house.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.devmartynov.house.app.model.Result
import io.devmartynov.house.domain.model.Service
import io.devmartynov.house.domain.useCase.GetMeterReadingsUseCase
import io.devmartynov.house.ui.screen.main.model.MeterReadingsPageEvent
import io.devmartynov.house.ui.screen.main.model.MeterReadingsPageState
import io.devmartynov.house.app.model.ActionStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Вью модель страницы списка показаний счетчика(страница в HorizontalPager)
 */
@HiltViewModel
class MeterReadingsPageViewModel @Inject constructor(
    private val getMeterReadingsUseCase: GetMeterReadingsUseCase,
) : ViewModel() {
    var service: Service? = null
    val uiState = MutableStateFlow(MeterReadingsPageState())

    init {
        loadMeterReadings(isInitialRequest = true)
    }

    /**
     * Обработка события на странице списка показаний счетчика
     * @param event событие на экране
     */
    fun handleEvent(event: MeterReadingsPageEvent) {
        when (event) {
            is MeterReadingsPageEvent.DataRefreshed -> {
                loadMeterReadings()
            }
        }
    }

    /**
     * Получает список показаний счетчиков
     *
     * @param isInitialRequest начальная загрузка или нет
     */
    private fun loadMeterReadings(isInitialRequest: Boolean = false) {
        uiState.value = uiState.value.copy(
            status = if (isInitialRequest) {
                ActionStatus.Loading
            } else {
                ActionStatus.Refreshing
            }
        )

        viewModelScope.launch(Dispatchers.IO) {
            val result = getMeterReadingsUseCase(Service.GAS)

            withContext(Dispatchers.Main) {
                when (result) {
                    is Result.Success -> {
                        uiState.value = uiState.value.copy(
                            status = ActionStatus.Success(),
                            meterReadings = result.value,
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