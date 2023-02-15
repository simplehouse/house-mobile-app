package io.devmartynov.house.app

import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import io.devmartynov.house.domain.enums.Theme
import io.devmartynov.house.app.model.ThemeManager
import io.devmartynov.house.domain.repositories.SettingsStore

class ThemeManagerImpl @Inject constructor(
    settingsStore: SettingsStore,
) : ThemeManager() {
    private val theme = MutableStateFlow(settingsStore.getTheme())

    override fun notifyListeners() {
        val theme = theme.value
        listeners.forEach { it.onChanged(theme) }
    }

    override fun setTheme(theme: Theme) {
        this.theme.value = theme
        notifyListeners()
    }

    override fun getTheme(): Theme {
        return theme.value
    }

    override fun checkIsDark(theme: Theme): Boolean {
        return theme == Theme.DARK
    }

    override fun isSystem(): Boolean {
        return theme.value == Theme.SYSTEM
    }

    override fun isDark(): Boolean {
        return theme.value == Theme.DARK
    }

    override fun isLight(): Boolean {
        return theme.value == Theme.LIGHT
    }
}