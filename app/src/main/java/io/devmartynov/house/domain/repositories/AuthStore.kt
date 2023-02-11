package io.devmartynov.house.domain.repositories

/**
 * Локальное хранилище для данных авторизации
 */
interface AuthStore {

    /**
     * Записывает токен доступа
     *
     * @param accessToken токен доступа
     */
    fun setAccessToken(accessToken: String)

    /**
     * Получает токен доступа
     *
     * @return если установлен то токен, иначе null
     */
    fun getAccessToken(): String?
}