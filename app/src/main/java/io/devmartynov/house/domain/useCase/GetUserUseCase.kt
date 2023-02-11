package io.devmartynov.house.domain.useCase

import javax.inject.Inject
import io.devmartynov.house.domain.model.Result
import io.devmartynov.house.domain.model.User
import io.devmartynov.house.domain.repositories.AuthRepository
import io.devmartynov.house.domain.repositories.UserStore

/**
 * Сценарий получения информации о пользователе
 *
 * @param authRepository репозиторий авторизации
 */
class GetUserUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val userStore: UserStore,
) {
    /**
     * Получает информацию о пользователе и сохраняет данные локально
     *
     * @return информацию о пользователе либо ошибки
     */
    suspend operator fun invoke(): Result<User> {
        val user = userStore.getUser()
        if (user != null) {
            return Result.Success(value = user)
        }

        val result = authRepository.getUser()
        if (result is Result.Success) {
            userStore.setUser(result.value)
        }

        return result
    }
}