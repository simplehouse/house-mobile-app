package io.devmartynov.house

import io.devmartynov.house.domain.model.Auth
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class AuthImpl @Inject constructor() : Auth() {
    private val accessToken = MutableStateFlow<String?>(null)
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