package io.devmartynov.house.ui.shared.model

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
     */
    object Success : ActionStatus()

    /**
     * Происходит ли начальная загрузка
     *
     * @return true если происходит загурзка, иначе false
     */
    fun isLoading(): Boolean {
        return this == Loading
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