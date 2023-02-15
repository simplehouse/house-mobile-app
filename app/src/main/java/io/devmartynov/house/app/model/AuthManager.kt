package io.devmartynov.house.app.model

/**
 * Компонент авторизации.
 * Используется для выполнения глобальных задач в приложении(редирект на экран входа,
 * подстановка токена в запрос).
 */
abstract class AuthManager : Notifier<Boolean>(), AuthChanger