package io.devmartynov.house.ui.screen.addMeterReading.model

/**
 * Событие на экране добавления показания счетчика
 */
sealed class AddMeterReadingEvent {
    /**
     * Событие изменения значения счетчки в поле ввода
     *
     * @param value значение счетчка
     */
    class MeterReadingValueChanged(val value: String) : AddMeterReadingEvent()

    /**
     * Событие сохранения показания счетчка
     */
    object SaveMeterReading : AddMeterReadingEvent()

    /**
     * Событие удаления ошибки
     */
    object ErrorDismissed : AddMeterReadingEvent()
}
