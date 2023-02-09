package io.devmartynov.house.ui.screen.main.model

/**
 * События на экране показаний счетчиков
 */
sealed class MeterReadingsEvent {
    /**
     * Событие обновления данных: даты подачи показаний и списка показаний
     *
     * @param service услуга
     */
    class DataRefreshed(val service: Service) : MeterReadingsEvent()
}