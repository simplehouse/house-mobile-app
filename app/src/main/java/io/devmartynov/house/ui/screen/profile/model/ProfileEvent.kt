package io.devmartynov.house.ui.screen.profile.model

import io.devmartynov.house.ui.shared.model.Theme


/**
 * События на экране профиля пользователя
 */
sealed class ProfileEvent {

    /**
     * Событие изменение цветовой темы
     *
     * @param theme цветовая тема
     */
    class ThemeChanged(val theme: Theme) : ProfileEvent()

    /**
     * Событие удаления профиля пользователя
     */
    object ProfileDeleted : ProfileEvent()
}