package io.devmartynov.house.data.remote

/**
 * Коды состояния http
 */
enum class HttpCode(val code: Int) {
    FORBIDDEN(403),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500)
}