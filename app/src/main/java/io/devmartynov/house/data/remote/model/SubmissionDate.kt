package io.devmartynov.house.data.remote.model

/**
 * Дата подачи показания
 *
 * @param id уникальный ключ
 * @param date дата
 */
data class SubmissionDate(
    val id: Int,
    val date: String,
)
