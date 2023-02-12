package io.devmartynov.house.domain.repositories

import io.devmartynov.house.app.model.Result
import io.devmartynov.house.domain.model.SignInResponse
import io.devmartynov.house.domain.model.User

/**
 * Репозиторий авторизации
 */
interface AuthRepository {
    /**
     * Авторизация пользователя
     *
     * @param email email адрес, он же логин
     * @param password пароль
     *
     * @return в случае успеха токен доступа иначе ошибки валидации/http
     */
    suspend fun signIn(email: String, password: String): Result<SignInResponse>

    /**
     * Получает информацию о пользователе.
     *
     * @return в случае успеха модель пользователя иначе ошибки http
     */
    suspend fun getUser(): Result<User>
}