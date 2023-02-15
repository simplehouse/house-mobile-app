package io.devmartynov.house.domain.useCase

import io.devmartynov.house.app.enums.Theme
import io.devmartynov.house.app.model.ThemeManager
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class SetThemeUseCase @Inject constructor(
    private val themeManager: ThemeManager
) {
    val theme: StateFlow<Theme> = themeManager.theme

    fun setTheme(theme: Theme) {
        themeManager.setTheme(theme)
    }

    fun isDark(theme: Theme): Boolean? {
        return themeManager.isDark(theme)
    }
}