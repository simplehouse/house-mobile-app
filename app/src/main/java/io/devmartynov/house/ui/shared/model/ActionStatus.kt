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
     *
     * @property lastTime таймстамп последнего обновления
     * @property counter счетчик обновлений
     */
    class Refreshing: ActionStatus() {
        companion object {
            var lastTime: Long = System.currentTimeMillis()
            var counter = 0
        }

        init {
            lastTime = System.currentTimeMillis()
            counter++
        }
    }

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
}