package io.devmartynov.house.data.remote.model

/**
 * Ответ на запрос авторизации /auth/login
 *
 * @param accessToken токен доступа
 * @param confirm ссылка на подтверждение входа(в этом приложении использоваться не будет => всегда будет равна null)
 * @param errors ошибки валидации email и пароля при входе
 */
data class SignInResponse(
    val accessToken: String?,
    val confirm: String?,
    val errors: SignInResponseErrors?
)
