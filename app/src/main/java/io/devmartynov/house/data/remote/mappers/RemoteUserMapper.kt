package io.devmartynov.house.data.remote.mappers

import io.devmartynov.house.data.remote.model.User
import io.devmartynov.house.domain.model.UserEntity

/**
 * Маппинг в доменную модель
 *
 * @return доменную модель пользователя
 */
fun User.toDomainModel(): UserEntity {
    return UserEntity(
        id = this.id,
        email = this.email,
        isBanned = this.isBanned == 0,
        name = this.firstName,
        avatarUrl = null,
    )
}