package io.devmartynov.house.data.remote.model

/**
 * Коммунальная услуга в квитанции
 *
 * @param id уникальный ключ
 * @param value значение по счетчику
 * @param label название коммунальной услуги
 * @param amountToPay цена по коммунальной услуге
 */
data class ServiceInvoice(
    val id: Int,
    val label: String,
    val value: Float,
    val amountToPay: Float,
)