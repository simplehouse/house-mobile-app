package io.devmartynov.house.domain.useCase

import io.devmartynov.house.app.model.ThemeManager
import io.devmartynov.house.domain.enums.Theme
import javax.inject.Inject

/**
 * Сценарий получения цветовой темы приложения
 */
class GetThemeUseCase @Inject constructor(
    private val themeManager: ThemeManager
) {
    operator fun invoke(): Theme {
        return themeManager.getTheme()
    }
}