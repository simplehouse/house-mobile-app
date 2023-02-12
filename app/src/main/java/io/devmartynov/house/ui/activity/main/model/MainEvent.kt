package io.devmartynov.house.ui.activity.main.model

import io.devmartynov.house.app.model.Theme

/**
 * События в активити(глобальные)
 */
sealed class MainEvent {
    /**
     * Событие изменения цветовой темы в приложении
     *
     * @property theme новая цветовая тема
     */
    class ThemeChanged(val theme: Theme) : MainEvent()
}