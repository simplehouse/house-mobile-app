package io.devmartynov.house.app.model

/**
 * Компонент работает с авторизацией
 */
interface AuthChanger {
    /**
     * Авторизован ли сейчас пользователь
     *
     * @return true, если есть токен доступа, иначе false
     */
    fun isAuthorized(): Boolean

    /**
     * Токен доступа
     *
     * @return токен доступа или null
     */
    fun getAccessToken(): String?

    /**
     * Авторизация в приложении
     * Просто сохраняет у себя токен доступа и оповещает подписчиков
     *
     * @param accessToken токен доступа
     */
    fun signIn(accessToken: String)

    /**
     * Выход из аккаунта
     * Удаляет у себя токен доступа и оповещает подписчиков
     */
    fun signOut()
}