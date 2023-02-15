package io.devmartynov.house.domain.model

/**
 * Пользователь
 *
 * @param id уникальный id
 * @param email адрес эл. почты, он же логин
 * @param isBanned забанен ли пользователь
 * @param name имя пользователя
 * @param avatarUrl ссылка на аватар пользователя
 */
data class UserEntity(
    val id: Int,
    val email: String,
    val isBanned: Boolean,
    val name: String,
    val avatarUrl: String?,
)