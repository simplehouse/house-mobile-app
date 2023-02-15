package io.devmartynov.house.ui.screen.invoices.model

import io.devmartynov.house.domain.model.InvoiceEntity

/**
 * Событие на странице квитанций
 */
sealed class InvoicesEvent {
    /**
     * Обновление списка квитанций
     */
    object DataRefreshed : InvoicesEvent()

    /**
     * Загрузка квитанции
     *
     * @param invoice квитанция
     */
    class InvoiceDownloaded(val invoice: InvoiceEntity) : InvoicesEvent()

    /**
     * Сброс статуса загрузки квитанции
     */
    object InvoiceDownloadedIdle : InvoicesEvent()

    /**
     * Поделиться квитанцией
     *
     * @param invoice квитанция
     */
    class InvoiceShared(val invoice: InvoiceEntity) : InvoicesEvent()
}
