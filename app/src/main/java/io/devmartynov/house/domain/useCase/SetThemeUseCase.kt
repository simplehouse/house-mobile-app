package io.devmartynov.house.domain.useCase

import io.devmartynov.house.domain.enums.Theme
import io.devmartynov.house.app.model.ThemeManager
import io.devmartynov.house.domain.repositories.SettingsStore
import javax.inject.Inject

/**
 * Сценарий изменения цветовой темы приложения
 *
 * @param themeManager
 * @param settingsStore
 */
class SetThemeUseCase @Inject constructor(
    private val themeManager: ThemeManager,
    private val settingsStore: SettingsStore,
) {
    operator fun invoke(theme: Theme) {
        settingsStore.setTheme(theme)
        themeManager.setTheme(theme)
    }
}