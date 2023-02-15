package io.devmartynov.house.app.model

/**
 * Статус асинхроннгого действия
 */
sealed class ActionStatus {
    /**
     * Действие не выполняется
     */
    object Idle : ActionStatus()

    /**
     * Действие загружается первый раз. Начальная загрузка
     */
    object Loading : ActionStatus()

    /**
     * Действие загружается повторно. Обновление
     */
    object Refreshing : ActionStatus()

    /**
     * Во время выполнения действия произошла ошибка
     *
     * @param error текст ошибки
     */
    class Error(val error: String? = null) : ActionStatus()


    /**
     * Успешное выполнение действия
     *
     * @param data данные обозначающие успех выполнения действия
     */
    class Success(val data: Any? = null) : ActionStatus()

    /**
     * Получает данные после успешного результата действий
     */
    fun getSuccessfulData(): Any? {
        if (this is Success) {
            return this.data
        }
        return null
    }
    /**
     * Успешно ли завершилось действие
     */
    fun isSuccessful(): Boolean {
        return this is Success
    }

    /**
     * Происходит ли начальная загрузка
     *
     * @return true если происходит загурзка, иначе false
     */
    fun isLoading(): Boolean {
        return this is Loading
    }

    /**
     * Происходит ли обновление
     *
     * @return true если происходит обновление, иначе false
     */
    fun isRefreshing(): Boolean {
        return this is Refreshing
    }

    /**
     * Была ли ошибка при выполнении действия
     *
     * @return true если ошибка есть, иначе false
     */
    fun hasError(): Boolean {
        return (this is Error) && this.error.isNullOrBlank()
    }
}