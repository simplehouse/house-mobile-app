package io.devmartynov.house.app

import io.devmartynov.house.app.model.AuthManager
import io.devmartynov.house.domain.repositories.AuthStore
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class AuthManagerImpl @Inject constructor(
    authStore: AuthStore
) : AuthManager() {
    private val accessToken = MutableStateFlow(authStore.getAccessToken())

    override fun notifyListeners() {
        val _isAuthorized = isAuthorized()
        listeners.forEach { it.onChanged(_isAuthorized) }
    }

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