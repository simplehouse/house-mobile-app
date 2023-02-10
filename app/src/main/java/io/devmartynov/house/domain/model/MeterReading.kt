package io.devmartynov.house.domain.model

/**
 * Показание счетчика
 *
 * @param id уникальный ключ показания
 * @param createDate дата подачи показания
 * @param isExpired
 * @param toPayAmount сумма, которую нужно заплатить
 * @param service коммунальная услуга
 * @param diffWithPrevValue разница по значению с прошлым месяцем
 * @param value значение по счетчику на момент подачи
 * @param usageAmount сколько было использовано за этот месяц
 */
data class MeterReading(
    val id: Int = -1,
    val createDate: String = "",
    val isExpired: Boolean = false,
    val toPayAmount: Int = 0,
    val service: Service = Service.GAS,
    val diffWithPrevValue: Float = 0f,
    val value: Float = 0f,
    val usageAmount: Float = 0f,
) : java.io.Serializable
