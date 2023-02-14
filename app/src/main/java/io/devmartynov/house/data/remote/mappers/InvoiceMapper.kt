package io.devmartynov.house.data.remote.mappers

import io.devmartynov.house.data.remote.model.Invoice
import io.devmartynov.house.domain.model.InvoiceEntity

/**
 * Маппинг в доменную модель
 *
 * @return доменную модель квитанции
 */
fun Invoice.toDomainModel(): InvoiceEntity {
    return InvoiceEntity(
        id = id,
        createTime = createTime,
        servicesData = servicesData.map { it.toDomainModel() },
    )
}