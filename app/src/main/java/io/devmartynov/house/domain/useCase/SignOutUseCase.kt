package io.devmartynov.house.domain.useCase

import io.devmartynov.house.app.model.AuthManager
import io.devmartynov.house.domain.repositories.AuthStore
import javax.inject.Inject

/**
 * Сценарий выхода из аккаунта пользователя
 *
 * @param authManager компонент авторизации приложения
 * @param authStore
 */
class SignOutUseCase @Inject constructor(
    private val authManager: AuthManager,
    private val authStore: AuthStore,
) {
    operator fun invoke() {
        authStore.setAccessToken(null)
        authManager.signOut()
    }
}