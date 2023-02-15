package io.devmartynov.house.ui.screen.profile.model

import io.devmartynov.house.domain.enums.Theme

/**
 * Состояние экрана авторизации
 *
 * @param theme цветовая тема приложения
 * @param fullName данные о пользователе
 * @param email данные о пользователе
 * @param imageUrl данные о пользователе
 */
data class ProfileState(
    val theme: Theme = Theme.SYSTEM,
    val fullName: String? = null,
    val email: String? = null,
    val imageUrl: String? = null,
)