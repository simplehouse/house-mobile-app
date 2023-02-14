package io.devmartynov.house.domain.model

/**
 * Коммунальная услуга в квитанции
 *
 * @param id уникальный ключ
 * @param value значение по счетчику
 * @param amountToPay цена по коммунальной услуге
 */
data class ServiceInvoiceEntity(
    val id: Int,
    val value: Float,
    val amountToPay: Float,
)