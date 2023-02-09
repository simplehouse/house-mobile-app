package io.devmartynov.house.ui.screen.auth.signIn.model

/**
 * События на экране авторизации
 */
sealed class SignInEvent {
    /**
     * Событие изменение email в поле ввода
     *
     * @param email email
     */
    class EmailChanged(val email: String): SignInEvent()

    /**
     * Событие изменения пароля в поле ввода
     *
     * @param password пароль
     */
    class PasswordChanged(val password: String): SignInEvent()

    /**
     * Событие авторизации
     */
    object SignIn : SignInEvent()

    /**
     * Событие удаления ошибки
     */
    object ErrorDismissed : SignInEvent()
}
