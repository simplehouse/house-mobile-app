package io.devmartynov.house.ui.shared.model

import kotlinx.coroutines.flow.StateFlow

interface ThemeManager {
    val theme: StateFlow<Theme>

    fun setTheme(theme: Theme)

    fun isDark(theme: Theme): Boolean?
}