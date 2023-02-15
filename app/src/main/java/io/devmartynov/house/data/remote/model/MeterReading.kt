package io.devmartynov.house.data.remote.model

/**
 * Показание счетчика
 *
 * @param id уникальный ключ показания
 * @param isSubmissionDateExpired просрочена ли дата подачи показания
 * @param createTime дата подачи показания
 * @param toPayAmount сумма, которую нужно заплатить
 * @param service коммунальная услуга
 * @param diffWithPrevValue разница по значению с прошлым месяцем
 * @param value значение по счетчику на момент подачи
 */
data class MeterReading(
    val id: Int,
    val isSubmissionDateExpired: Boolean,
    val createTime: String,
    val toPayAmount: Float,
    val service: Int,
    val diffWithPrevValue: Float,
    val value: Float,
)