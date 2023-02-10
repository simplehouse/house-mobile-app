package io.devmartynov.house.ui.screen.main.model

/**
 * События для страницы списка показаний счетчика(страница в HorizontalPager)
 */
sealed class MeterReadingsPageEvent {
    /**
     * Событие обновления списка показаний счетчика
     */
    object DataRefreshed : MeterReadingsPageEvent()
}