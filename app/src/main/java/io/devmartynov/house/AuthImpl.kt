package io.devmartynov.house

import io.devmartynov.house.domain.model.Auth
import io.devmartynov.house.domain.repositories.AuthStore
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class AuthImpl @Inject constructor(
    private val authStore: AuthStore,
) : Auth() {
    private val accessToken = MutableStateFlow(authStore.getAccessToken())
    override fun isAuthorized(): Boolean {
        return accessToken.value != null
    }

    override fun getAccessToken(): String? {
        return accessToken.value
    }

    override fun signIn(accessToken: String) {
        this.accessToken.value = accessToken
        notifyListeners()
    }

    override fun signOut() {
        accessToken.value = null
        notifyListeners()
    }
}