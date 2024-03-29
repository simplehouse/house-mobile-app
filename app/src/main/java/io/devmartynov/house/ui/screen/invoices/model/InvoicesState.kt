package io.devmartynov.house.ui.screen.invoices.model

import io.devmartynov.house.app.model.ActionStatus
import io.devmartynov.house.domain.model.InvoiceEntity

/**
 * Состояние на экране квитанций
 *
 * @param invoices список квитанций
 * @param invoicesStatus статус квитанций
 * @param invoiceDownloadedStatus статус сохранения документа квитанции
 */
data class InvoicesState(
    val invoices: List<InvoiceEntity> = emptyList(),
    val invoicesStatus: ActionStatus = ActionStatus.Idle,
    val invoiceDownloadedStatus: ActionStatus = ActionStatus.Idle,
)