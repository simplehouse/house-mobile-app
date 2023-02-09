package io.devmartynov.house.ui.screen.auth.signIn.model

import io.devmartynov.house.ui.screen.auth.model.PasswordRequirements
import io.devmartynov.house.ui.shared.model.ActionStatus

/**
 * Состояние экрана авторизации
 *
 * @param email e-mail пользователя. он же логин для входа
 * @param password пароль для входа
 * @param completedPasswordRequirements выполненные требования к паролю. Нужны для валидации перед отравкой данных
 * @param status статус выполнения авторизации
 */
data class SignInState(
    val email: String? = null,
    val password: String? = null,
    val completedPasswordRequirements: List<PasswordRequirements> = emptyList(),
    val status: ActionStatus = ActionStatus.Idle,
) {

    /**
     * Проверяет валидны ли данные в форме
     * @return true данные заполнены и соответсвуют требованиям, иначе false
     */
    fun isFormValid(): Boolean {
        return password?.isNotEmpty() == true && email?.isNotEmpty() == true;
        // TODO доделать вариант с валидацией по требованиям к паролю
//        return password?.isNotEmpty() == true
//                && email?.isNotEmpty() == true
//                && completedPasswordRequirements.containsAll(PasswordRequirements.values().toList())
    }
}
