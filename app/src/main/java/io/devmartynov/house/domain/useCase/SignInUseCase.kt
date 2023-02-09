package io.devmartynov.house.domain.useCase

import io.devmartynov.house.domain.model.Auth
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val auth: Auth
) {
    operator fun invoke() {
        return auth.signIn()
    }
}