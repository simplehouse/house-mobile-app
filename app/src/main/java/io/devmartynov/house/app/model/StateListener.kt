package io.devmartynov.house.app.model

/**
 * Слушатель изменения событий
 */
interface StateListener<T : Any> {
    fun onChanged(value: T)
}