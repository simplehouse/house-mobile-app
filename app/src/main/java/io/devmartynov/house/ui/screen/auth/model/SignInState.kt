package io.devmartynov.house.ui.screen.auth.model

/**
 * Состояние экрана авторизации
 *
 * @param email e-mail пользователя. он же логин для входа
 * @param password пароль для входа
 * @param completedPasswordRequirements выполненные требования к паролю. Нужны для валидации перед отравкой данных
 * @param isLoading выполняется ли сейчас запрос к API для отправки данных формы
 * @param error ошибка при выполнении запроса к API
 */
data class SignInState(
    val email: String? = null,
    val password: String? = null,
    val completedPasswordRequirements: List<PasswordRequirements> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
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
