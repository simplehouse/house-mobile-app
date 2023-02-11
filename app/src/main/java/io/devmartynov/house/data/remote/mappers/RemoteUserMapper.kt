package io.devmartynov.house.data.remote.mappers

import io.devmartynov.house.data.remote.model.RemoteUser
import io.devmartynov.house.domain.model.User
import io.devmartynov.house.domain.model.UserRole

/**
 * Маппинг в доменную модель
 *
 * @return доменную модель пользователя
 */
fun RemoteUser.toDomainModel(): User {
    return User(
        id = this.id,
        email = this.email,
        isBanned = this.isBanned,
        name = this.name,
        role = UserRole.values().first { role -> role.name == this.role.uppercase() },
    )
}

/**
 * Маппинг из доменной модели
 *
 * @param user доменная модель
 *
 * @return модель пользователя
 */
fun RemoteUser.fromDomainModel(user: User): RemoteUser {
    return RemoteUser(
        id = user.id,
        email = user.email,
        isBanned = user.isBanned,
        name = user.name,
        role = user.role.name,
    )
}