package io.devmartynov.house.domain.model

/**
 * Компонент авторизации.
 * Используется для выполнения глобальных задач в приложении(редирект на экран входа,
 * подстановка токена в запрос).
 */
abstract class Auth {
    private val listeners = mutableSetOf<AuthStateListener>()

    /**
     * Авторизован ли сейчас пользователь
     *
     * @return true, если есть токен доступа, иначе false
     */
    abstract fun isAuthorized(): Boolean

    /**
     * Токен доступа
     *
     * @return токен доступа или null
     */
    abstract fun getAccessToken(): String?

    /**
     * Авторизация в приложении
     * Просто сохраняет у себя токен доступа и оповещает подписчиков
     * @see notifyListeners
     *
     * @param accessToken токен доступа
     */
    abstract fun signIn(accessToken: String)

    /**
     * Выход из аккаунта
     * Удаляет у себя токен доступа и оповещает подписчиков
     *
     * @see notifyListeners
     */
    abstract fun signOut()

    /**
     * Оповещает подписчиков об изменении состояния авторизации
     */
    protected fun notifyListeners() {
        val _isAuthorized = isAuthorized()
        listeners.forEach { it.onAuthChanged(_isAuthorized) }
    }

    /**
     * Добавляет подпичсика.
     */
    fun addChangeListener(listener: AuthStateListener) {
        listeners.add(listener)
    }

    /**
     * Удаялет подписчика
     */
    fun removeChangeListener(listener: AuthStateListener) {
        listeners.remove(listener)
    }

    /**
     * Удаялет всех подписчиков
     */
    fun removeAllChangeListeners() {
        listeners.clear()
    }
}