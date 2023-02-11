package io.devmartynov.house.data.remote.model

/**
 * Показание счетчика. Модель приходит с бекенда
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
data class RemoteMeterReading(
    val id: Int,
    val createDate: String,
    val isExpired: Boolean,
    val toPayAmount: Int,
    val service: Int,
    val diffWithPrevValue: Float,
    val value: Float,
    val usageAmount: Float,
)