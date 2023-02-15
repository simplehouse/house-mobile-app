package io.devmartynov.house.app.model

import io.devmartynov.house.domain.enums.Theme

/**
 * Компонент цветовой темы приложения
 */
abstract class ThemeManager : Notifier<Theme>(), ThemeChanger