package io.devmartynov.house.data.remote.mappers

import io.devmartynov.house.app.helpers.Utils
import io.devmartynov.house.data.remote.model.SubmissionDate
import io.devmartynov.house.domain.model.SubmissionDateEntity

/**
 * Маппинг в доменную модель
 *
 * @return дату в виде временной метки
 */
fun SubmissionDate.toDomainModel(): SubmissionDateEntity {
    return Utils.getTimeFromStringDate(date)
}