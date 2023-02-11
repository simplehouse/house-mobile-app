package io.devmartynov.house.data.remote.mappers

import io.devmartynov.house.data.remote.model.RemoteMeterReading
import io.devmartynov.house.domain.model.MeterReading
import io.devmartynov.house.domain.model.Service

/**
 * Маппинг в доменную модель
 *
 * @return доменную модель показания счетчика
 */
fun RemoteMeterReading.toDomainModel(): MeterReading {
    return MeterReading(
        id = this.id,
        createDate = this.createDate,
        isExpired = this.isExpired,
        toPayAmount = this.toPayAmount,
        service = Service.values()[this.service],
        diffWithPrevValue = this.diffWithPrevValue,
        value = this.value,
        usageAmount = this.usageAmount,
    )
}

/**
 * Маппинг из доменной модели
 *
 * @param model доменная модель
 *
 * @return модель показания счетчика
 */
fun RemoteMeterReading.fromDomainModel(model: MeterReading): RemoteMeterReading {
    return RemoteMeterReading(
        id = model.id,
        createDate = model.createDate,
        isExpired = model.isExpired,
        toPayAmount = model.toPayAmount,
        service = model.service.ordinal,
        diffWithPrevValue = model.diffWithPrevValue,
        value = model.value,
        usageAmount = model.usageAmount,
    )
}