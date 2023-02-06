package io.devmartynov.house.ui.screen.auth.model

import androidx.annotation.StringRes
import io.devmartynov.house.R

/**
 * Требования к паролю для авторизации пользователя в приложении
 *
 * @param label текст требования. Строковый ресурс
 */
enum class PasswordRequirements(
    @StringRes val label: Int,
) {
    CAPITAL_LETTER(R.string.password_requirement_capital),
    NUMBER(R.string.password_requirement_digit),
    EIGHT_CHARACTERS(R.string.password_requirement_characters),
}
