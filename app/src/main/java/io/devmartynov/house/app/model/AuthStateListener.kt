package io.devmartynov.house.app.model

interface AuthStateListener {
    fun onAuthChanged(isAuthorized: Boolean)
}