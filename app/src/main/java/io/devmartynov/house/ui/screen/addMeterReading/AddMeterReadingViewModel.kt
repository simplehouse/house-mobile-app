package io.devmartynov.house.ui.screen.addMeterReading

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.devmartynov.house.ui.navigation.model.Route
import io.devmartynov.house.ui.screen.addMeterReading.model.AddMeterReadingEvent
import io.devmartynov.house.ui.screen.addMeterReading.model.AddMeterReadingState
import io.devmartynov.house.ui.screen.main.model.Services
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class AddMeterReadingViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val uiState = MutableStateFlow(AddMeterReadingState())
    private var service = Services.GAS.ordinal

    fun handleEvent(event: AddMeterReadingEvent) {
        when (event) {
            else -> {}
        }
    }

    init {
        service = savedStateHandle[Route.AddMeterReading.PARAM_METER_READING_SERVICE] ?: service
    }
}