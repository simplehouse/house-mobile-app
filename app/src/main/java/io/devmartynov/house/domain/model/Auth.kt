package io.devmartynov.house.domain.model

abstract class Auth {
    private val listeners = mutableSetOf<AuthStateListener>()

    abstract fun signIn()

    abstract fun signOut()

    fun addChangeListener(listener: AuthStateListener) {
        listeners.add(listener)
    }

    fun removeChangeListener(listener: AuthStateListener) {
        listeners.remove(listener)
    }

    fun removeAllChangeListeners() {
        listeners.clear()
    }
}