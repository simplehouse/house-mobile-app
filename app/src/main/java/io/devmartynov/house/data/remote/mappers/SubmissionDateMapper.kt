package io.devmartynov.house.data.remote.mappers

import io.devmartynov.house.data.remote.model.SubmissionDate

/**
 * Маппинг в доменную модель
 *
 * @return дату в виде строки(пример "2023-02-15 00:00:00")
 */
fun SubmissionDate.toDomainModel(): String {
    return this.date
}