package io.devmartynov.house.ui.screen.main.model

/**
 * Показание счетчика
 *
 * @param id уникальный ключ показания
 * @param createDate дата подачи показания
 * @param isExpired
 * @param amount сумма, которую нужно заплатить
 * @param service коммунальная услуга
 */
data class MeterReading(
    val id: Int,
    val createDate: String,
    val isExpired: Boolean,
    val amount: Int,
    val service: Services,
)
