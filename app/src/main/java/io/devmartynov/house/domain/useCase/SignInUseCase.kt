package io.devmartynov.house.domain.useCase

import io.devmartynov.house.app.model.AuthManager
import io.devmartynov.house.domain.repositories.AuthRepository
import javax.inject.Inject
import io.devmartynov.house.app.model.Result
import io.devmartynov.house.domain.model.SignInResponse
import io.devmartynov.house.domain.repositories.AuthStore

/**
 * Сценарий авторизации
 *
 * @param authRepository репозиторий авторизации
 * @param authManager компонент авторизации приложения
 */
class SignInUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val authManager: AuthManager,
    private val authStore: AuthStore,
) {
    suspend operator fun invoke(email: String, password: String): Result<SignInResponse> {
        val result = authRepository.signIn(email, password)
        if (result is Result.Success) {
            val token = result.value.accessToken!!
            authManager.signIn(token)
            authStore.setAccessToken(token)
        }
        return result
    }
}