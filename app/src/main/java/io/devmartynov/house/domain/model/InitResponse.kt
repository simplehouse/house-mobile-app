package io.devmartynov.house.domain.model

/**
 * Ответ на запрос /init
 */
data class InitResponse(
    val user: User?
)