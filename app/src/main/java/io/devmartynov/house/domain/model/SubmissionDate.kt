package io.devmartynov.house.domain.model

import java.text.SimpleDateFormat
import java.util.*

typealias SubmissionDate = Long

fun SubmissionDate.format(pattern: String): String {
    return try {
        SimpleDateFormat(pattern, Locale.UK)
            .format(Date(this))
    } catch (e: Exception) {
        e.toString()
    }
}