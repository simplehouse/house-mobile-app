package io.devmartynov.house.app.model

/**
 * Штука на изменение которой можно подписаться и она будет уведомит об изменении
 */
abstract class Notifier<T : Any> {
    protected val listeners = mutableSetOf<StateListener<T>>()

    /**
     * Оповещает подписчиков об изменениях
     */
    abstract fun notifyListeners()

    /**
     * Добавляет подпичсика.
     */
    fun addChangeListener(listener: StateListener<T>) {
        listeners.add(listener)
    }

    /**
     * Удаялет подписчика
     */
    fun removeChangeListener(listener: StateListener<T>) {
        listeners.remove(listener)
    }

    /**
     * Удаялет всех подписчиков
     */
    fun removeAllChangeListeners() {
        listeners.clear()
    }
}