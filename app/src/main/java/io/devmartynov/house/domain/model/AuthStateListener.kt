package io.devmartynov.house.domain.model

interface AuthStateListener {
    fun onAuthChanged(isAuthorized: Boolean)
}