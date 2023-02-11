package io.devmartynov.house.data.remote.mappers

import io.devmartynov.house.data.remote.model.RemoteUser
import io.devmartynov.house.domain.model.User

/**
 * Маппинг в доменную модель
 *
 * @return доменную модель пользователя
 */
fun RemoteUser.toDomainModel(): User {
    return User(
        id = this.id,
        email = this.email,
        isBanned = this.isBanned == 0,
        name = this.firstName,
        avatarUrl = null,
    )
}