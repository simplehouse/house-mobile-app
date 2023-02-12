package io.devmartynov.house.domain.useCase

import io.devmartynov.house.app.model.Auth
import io.devmartynov.house.domain.repositories.AuthStore
import javax.inject.Inject

/**
 * Сценарий выхода из аккаунта пользователя
 *
 * @param auth компонент авторизации приложения
 * @param authStore
 */
class SignOutUseCase @Inject constructor(
    private val auth: Auth,
    private val authStore: AuthStore,
) {
    operator fun invoke() {
        authStore.setAccessToken(null)
        auth.signOut()
    }
}