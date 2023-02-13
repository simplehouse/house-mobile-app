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
        id = id,
        isSubmissionDateExpired = isSubmissionDateExpired,
        createTime = createTime,
        toPayAmount = toPayAmount,
        service = Service.values()[service],
        diffWithPrevValue = diffWithPrevValue,
        value = value,
        usageAmount = diffWithPrevValue,
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
        isSubmissionDateExpired = model.isSubmissionDateExpired,
        createTime = model.createTime,
        toPayAmount = model.toPayAmount,
        service = model.service.ordinal,
        value = model.value,
        diffWithPrevValue = model.diffWithPrevValue,
    )
}