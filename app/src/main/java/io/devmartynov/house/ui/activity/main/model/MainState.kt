package io.devmartynov.house.ui.activity.main.model

import io.devmartynov.house.domain.model.User
import io.devmartynov.house.ui.shared.model.ActionStatus
import io.devmartynov.house.ui.shared.model.Theme

/**
 * Состояние на активити(глобальное состояние)
 *
 * @param isAuthorized авторизован ли пользователь
 * @param theme текущая цветовая тема
 * @param getUserStatus стутус действия по получению пользователя
 * @param user текущий пользователь приложения
 */
data class MainState(
    val isAuthorized: Boolean = false,
    val theme: Theme = Theme.SYSTEM,
    val getUserStatus: ActionStatus = ActionStatus.Idle,
    val user: User? = null,
)
