package io.devmartynov.house.ui.screen.addMeterReading.model

import io.devmartynov.house.app.model.ActionStatus

const val METER_READING_VALUE_MIN_LENGTH = 8

/**
 * Состояние экрана добавления показания счетчка
 *
 * @param meterReading значение счетчика
 * @param status статус сохранения показания счетчка
 */
data class AddMeterReadingState(
    val meterReading: String? = null,
    val status: ActionStatus = ActionStatus.Idle,
) {
    /**
     * Проверяет валидно ли введенное значение счетчика
     *
     * @return true если валидно, иначе false
     */
    fun isMeterReadingValid(): Boolean {
        return !meterReading.isNullOrEmpty()
                && meterReading.length == METER_READING_VALUE_MIN_LENGTH
    }
}