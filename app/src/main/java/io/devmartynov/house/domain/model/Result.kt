package io.devmartynov.house.domain.model

/**
 * Результат выполнения действия
 */
sealed class Result<out T : Any> {
    /**
     * Успешный результат выполнения.
     *
     * @param value результат успешного выполнения
     */
    class Success<out T : Any>(val value: T) : Result<T>()

    /**
     * Неуспешный результат выполнения.
     *
     * @param errors текст ошибок(http, ошибки безнес логики)
     */
    class Failure(val errors: String) : Result<Nothing>()
}
