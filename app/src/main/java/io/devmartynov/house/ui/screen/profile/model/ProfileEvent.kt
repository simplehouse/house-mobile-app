package io.devmartynov.house.ui.screen.profile.model


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