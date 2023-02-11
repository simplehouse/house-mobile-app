package io.devmartynov.house.domain.repositories

import io.devmartynov.house.domain.model.InitResponse
import io.devmartynov.house.domain.model.Result
import io.devmartynov.house.domain.model.SignInResponse

/**
 * Репозиторий авторизации
 */
interface AuthRepository {
    suspend fun signIn(email: String, password: String): Result<SignInResponse>

    suspend fun init(): Result<InitResponse>
}