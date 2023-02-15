package io.devmartynov.house.domain.model

import java.text.SimpleDateFormat
import java.util.*

typealias SubmissionDateEntity = Long

fun SubmissionDateEntity.format(pattern: String): String {
    return try {
        SimpleDateFormat(pattern, Locale.UK)
            .format(Date(this))
    } catch (e: Exception) {
        e.toString()
    }
}