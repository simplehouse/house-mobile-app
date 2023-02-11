package io.devmartynov.house.domain.repositories

import io.devmartynov.house.domain.model.User

/**
 * Локальное хранилище для данных пользователя
 */
interface UserStore {
    /**
     * Записывает данные пользователя
     *
     * @param user пользователь
     */
    fun setUser(user: User)

    /**
     * Получает данные о пользователе
     *
     * @return пользователя
     */
    fun getUser(): User?
}