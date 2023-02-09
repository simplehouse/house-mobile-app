package io.devmartynov.house.ui.shared.model

import androidx.annotation.StringRes
import io.devmartynov.house.R

/**
 * Цветовая тема приложения
 *
 * @param label название темы. Строковый ресурс
 */
enum class Theme(
    @StringRes val label: Int
) {
    LIGHT(R.string.theme_light),
    DARK(R.string.theme_dark),
    SYSTEM(R.string.theme_system),
}
