package io.devmartynov.house.data.remote.mappers

import io.devmartynov.house.data.remote.model.MeterReading
import io.devmartynov.house.domain.model.MeterReadingEntity
import io.devmartynov.house.domain.model.Service

/**
 * Маппинг в доменную модель
 *
 * @return доменную модель показания счетчика
 */
fun MeterReading.toDomainModel(): MeterReadingEntity {
    return MeterReadingEntity(
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