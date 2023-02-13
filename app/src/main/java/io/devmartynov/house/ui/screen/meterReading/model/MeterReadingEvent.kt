package io.devmartynov.house.ui.screen.meterReading.model

/**
 * События на экране(боттом щит диалог) детальной информации показания счетчика
 */
sealed class MeterReadingEvent {
    /**
     * Событие загрузки квитанции об оплате коммунальных услуг
     */
    object InvoiceDownloaded : MeterReadingEvent()
}
