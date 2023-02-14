package io.devmartynov.house.ui.screen.invoices.model

/**
 * Событие на странице квитанций
 */
sealed class InvoicesEvent {
    /**
     * Обновление списка квитанций
     */
    object DataRefreshed : InvoicesEvent()
}
