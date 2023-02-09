package io.devmartynov.house.ui.screen.addMeterReading

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.devmartynov.house.domain.useCase.SaveMeterReadingUseCase
import io.devmartynov.house.ui.navigation.model.Route
import io.devmartynov.house.ui.screen.addMeterReading.model.AddMeterReadingEvent
import io.devmartynov.house.ui.screen.addMeterReading.model.AddMeterReadingState
import io.devmartynov.house.ui.screen.main.model.Service
import io.devmartynov.house.ui.shared.model.ActionStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Вью модель добавления показания счетчика
 *
 * @param savedStateHandle
 * @param saveMeterReadingUseCase
 */
@HiltViewModel
class AddMeterReadingViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val saveMeterReadingUseCase: SaveMeterReadingUseCase,
) : ViewModel() {
    val uiState = MutableStateFlow(AddMeterReadingState())
    private var service = Service.GAS.ordinal

    init {
        service = savedStateHandle[Route.AddMeterReading.PARAM_METER_READING_SERVICE] ?: service
    }

    /**
     * Обработка событий на экране добавления показания счетчика
     *
     * @param event событие на экране добавления показания счетчика
     * @see AddMeterReadingEvent
     */
    fun handleEvent(event: AddMeterReadingEvent) {
        when (event) {
            is AddMeterReadingEvent.MeterReadingValueChanged -> {
                updateMeterReading(event.value)
            }
            AddMeterReadingEvent.SaveMeterReading -> {
                saveMeterReading()
            }
            AddMeterReadingEvent.ErrorDismissed -> {
                dismissError()
            }
        }
    }

    /**
     * Обновляет значение счетчика в состоянии
     *
     * @param value новое значение счетчика
     */
    private fun updateMeterReading(value: String) {
        uiState.value = uiState.value.copy(meterReading = value)
    }

    /**
     * Сохраняет показание счетчика
     */
    private fun saveMeterReading() {
        uiState.value = uiState.value.copy(status = ActionStatus.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            saveMeterReadingUseCase(
                value = uiState.value.meterReading ?: "",
                service = Service.values()[service],
            )
            withContext(Dispatchers.Main) {
                uiState.value = uiState.value.copy(
                    meterReading = null,
                    status = ActionStatus.Success,
                )
            }
        }
    }

    /**
     * Убирает API ошибку сохранения показания счетчика
     */
    private fun dismissError() {
        uiState.value = uiState.value.copy(status = ActionStatus.Idle)
    }
}