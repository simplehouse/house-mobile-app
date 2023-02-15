package io.devmartynov.house.domain.repositories

import io.devmartynov.house.domain.enums.Theme

/**
 * Локальное хранилище для глобальных настроект приложения
 */
interface SettingsStore {
    /**
     * Записывает значение цветовой темы
     *
     * @param theme цветовая тема
     */
    fun setTheme(theme: Theme)

    /**
     * Получает значение цветовой темы
     *
     * @return цветовая тема либо null
     */
    fun getTheme(): Theme
}