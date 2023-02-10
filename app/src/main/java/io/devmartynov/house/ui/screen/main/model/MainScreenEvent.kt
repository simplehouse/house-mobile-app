package io.devmartynov.house.ui.screen.main.model

/**
 * События на главном экране
 */
sealed class MainScreenEvent {
    /**
     * Событие обновления следующих дат подачи показаний
     */
    object DataRefreshed : MainScreenEvent()
}