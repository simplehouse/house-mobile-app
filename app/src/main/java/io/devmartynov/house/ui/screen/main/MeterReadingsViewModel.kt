package io.devmartynov.house.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.devmartynov.house.ui.screen.main.model.MeterReadingsEvent
import io.devmartynov.house.ui.screen.main.model.MeterReadingsState
import io.devmartynov.house.ui.screen.main.model.ServiceState
import io.devmartynov.house.ui.screen.main.model.Service
import io.devmartynov.house.ui.shared.model.ActionStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Вью модель списка показаний счетчиков
 */
class MeterReadingsViewModel : ViewModel() {
    val uiState = MutableStateFlow(MeterReadingsState())

    /**
     * Обработка события на экране показаний счетчиков
     * @param event событие на экране показаний счетчиков
     */
    fun handleEvent(event: MeterReadingsEvent) {
        when (event) {
            is MeterReadingsEvent.DataRefreshed -> {
                refreshData(event.service)
            }
        }
    }

    /**
     * Обновляет данные.
     * Получает данные по дате подачи показаний, а также список показаний
     *
     * @param service услуга
     */
    private fun refreshData(service: Service) {
        val serviceState = uiState.value.get(service).copy(status = ActionStatus.Refreshing())

        updateState(serviceState)

        viewModelScope.launch(Dispatchers.IO) {
            // TODO repository method execution
            delay(2000L)

            withContext(Dispatchers.Main) {

            }
        }
    }

    private fun updateState(serviceState: ServiceState) {
        when (serviceState.service) {
            Service.GAS -> {
                uiState.value = uiState.value.copy(gas = serviceState)
            }
            Service.WATER -> {
                uiState.value = uiState.value.copy(water = serviceState)
            }
            Service.ELECTRICITY -> {
                uiState.value = uiState.value.copy(electricity = serviceState)
            }
        }
    }
}