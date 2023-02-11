package io.devmartynov.house.domain.model

/**
 * Промапленный ответ на запрос авторизации /auth/login
 *
 * @param accessToken токен доступа
 * @param errors ошибки валидации email и пароля при входе
 */
data class SignInResponse(
    val errors: String?,
    val accessToken: String?
)