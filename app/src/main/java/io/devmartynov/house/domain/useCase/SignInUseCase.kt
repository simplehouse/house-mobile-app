package io.devmartynov.house.domain.useCase

import io.devmartynov.house.app.model.Auth
import io.devmartynov.house.domain.repositories.AuthRepository
import javax.inject.Inject
import io.devmartynov.house.app.model.Result
import io.devmartynov.house.domain.model.SignInResponse
import io.devmartynov.house.domain.repositories.AuthStore

/**
 * Сценарий авторизации
 *
 * @param authRepository репозиторий авторизации
 * @param auth компонент авторизации приложения
 */
class SignInUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val auth: Auth,
    private val authStore: AuthStore,
) {
    suspend operator fun invoke(email: String, password: String): Result<SignInResponse> {
        val result = authRepository.signIn(email, password)
        if (result is Result.Success) {
            val token = result.value.accessToken!!
            auth.signIn(token)
            authStore.setAccessToken(token)
        }
        return result
    }
}