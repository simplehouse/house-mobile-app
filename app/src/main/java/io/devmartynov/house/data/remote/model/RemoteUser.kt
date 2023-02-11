package io.devmartynov.house.data.remote.model

/**
 * Пользователь
 *
 * @param id уникальный id
 * @param email адрес эл. почты, он же логин
 * @param isBanned забанен ли пользователь
 * @param name имя пользователя
 * @param role роль пользователя в приложении
 */
data class RemoteUser(
    val id: Int,
    val email: Int,
    val isBanned: Boolean,
    val name: String,
    val role: String
)