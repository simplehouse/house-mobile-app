package io.devmartynov.house.app.model

import io.devmartynov.house.domain.enums.Theme

/**
 * Компонент работает с цветовой темой
 */
interface ThemeChanger {
    fun setTheme(theme: Theme)

    fun getTheme(): Theme

    fun checkIsDark(theme: Theme): Boolean

    fun isSystem(): Boolean

    fun isDark(): Boolean

    fun isLight(): Boolean
}