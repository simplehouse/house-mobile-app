package io.devmartynov.house.ui.screen.meterReading

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MeterReadingViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
//    val uiState = MutableStateFlow(AddMeterState())
//
//    fun handleEvent(event: AddMeterEvent) {
//        when (event) {
//
//            else -> {}
//        }
//    }

    init {
//        val argument = savedStateHandle.get<Int>(DestinationOneArg).orEmpty()
//        state.value = argument
    }
}