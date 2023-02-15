package io.devmartynov.house.app.model

import io.devmartynov.house.app.enums.Theme
import kotlinx.coroutines.flow.StateFlow

interface ThemeManager {
    val theme: StateFlow<Theme>

    fun setTheme(theme: Theme)

    fun isDark(theme: Theme): Boolean?
}