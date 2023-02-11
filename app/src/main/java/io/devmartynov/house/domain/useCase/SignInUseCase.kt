package io.devmartynov.house.domain.useCase

import io.devmartynov.house.domain.model.Auth
import io.devmartynov.house.domain.repositories.AuthRepository
import javax.inject.Inject
import io.devmartynov.house.domain.model.Result
import io.devmartynov.house.domain.model.SignInResponse

/**
 * Сценарий авторизации
 *
 * @param authRepository репозиторий авторизации
 * @param auth компонент авторизации приложения
 */
class SignInUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val auth: Auth,
) {
    suspend operator fun invoke(email: String, password: String): Result<SignInResponse> {
        val result = authRepository.signIn(email, password)
        if (result is Result.Success) {
            auth.signIn(result.value.accessToken!!)
        }
        return result
    }
}