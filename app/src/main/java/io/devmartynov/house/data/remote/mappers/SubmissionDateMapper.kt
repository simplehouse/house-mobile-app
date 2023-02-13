package io.devmartynov.house.data.remote.mappers

import io.devmartynov.house.data.remote.model.SubmissionDate
import java.text.SimpleDateFormat
import java.util.*

/**
 * Маппинг в доменную модель
 *
 * @return дату в виде строки(пример "2023-02-15 00:00:00")
 */
fun SubmissionDate.toDomainModel(): io.devmartynov.house.domain.model.SubmissionDate {
    return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.UK)
        .parse(date)
        ?.time ?: 0
}