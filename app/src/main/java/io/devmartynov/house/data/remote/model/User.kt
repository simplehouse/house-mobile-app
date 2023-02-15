package io.devmartynov.house.data.remote.model

/**
 * Пользователь
 *
 * @param id уникальный id
 * @param email адрес эл. почты, он же логин
 * @param isBanned забанен ли пользователь
 * @param firstName имя пользователя
 * @param role роль пользователя в приложении
 * @param phone номер телефона пользователя
 * @param createTime время создания пользователя
 */
data class User(
    val id: Int,
    val email: String,
    val phone: String?,
    val isBanned: Int,
    val firstName: String,
    val role: String,
    val createTime: String,
)