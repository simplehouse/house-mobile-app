package io.devmartynov.house.data.remote.mappers

import io.devmartynov.house.data.remote.model.ServiceInvoice
import io.devmartynov.house.domain.model.ServiceInvoiceEntity

/**
 * Маппинг в доменную модель
 *
 * @return доменную модель данных сервиса в квитанции
 */
fun ServiceInvoice.toDomainModel(): ServiceInvoiceEntity {
    return ServiceInvoiceEntity(
        id = id,
        value = value,
        amountToPay = amountToPay,
    )
}