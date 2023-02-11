package io.devmartynov.house.data.remote.model

/**
 * Ошибки при валидации email и пароля при входе
 *
 * @param password ошибки пароля
 * @param ошибки email адреса
 */
data class SignInResponseErrors(
    val password: (List<String>)?,
    val email: (List<String>)?,
)