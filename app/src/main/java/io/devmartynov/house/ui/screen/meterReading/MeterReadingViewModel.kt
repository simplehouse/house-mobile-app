package io.devmartynov.house.ui.screen.meterReading

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.devmartynov.house.domain.model.MeterReading
import io.devmartynov.house.ui.screen.meterReading.model.MeterReadingEvent
import io.devmartynov.house.ui.screen.meterReading.model.MeterReadingState
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

/**
 * Вью модель экрана(боттом щит диалога) детальной информации показания счетчика
 */
@HiltViewModel
class MeterReadingViewModel @Inject constructor() : ViewModel() {
    private lateinit var meterReading: MeterReading
    val uiState = MutableStateFlow(MeterReadingState())

    /**
     * Обработка события на странице детальной информации показания счетчика
     * @param event событие на экране
     */
    fun handleEvent(event: MeterReadingEvent) {
        when (event) {
            is MeterReadingEvent.InvoiceDownloaded -> {
               // todo implement
            }
        }
    }

    fun addMeterReading(meterReading: MeterReading) {
        this.meterReading = meterReading
    }
}