package io.devmartynov.house.domain.useCase

import io.devmartynov.house.domain.model.InvoiceEntity
import io.devmartynov.house.domain.model.PdfService
import io.devmartynov.house.ui.screen.invoices.model.InvoicePdfFileInfo
import javax.inject.Inject
import io.devmartynov.house.app.model.Result

/**
 * Сценарий сохранения документа на устройство
 *
 * @param pdfService
 */
class SavePdfUseCase @Inject constructor(
    private val pdfService: PdfService,
) {
    operator fun invoke(invoice: InvoiceEntity): Result<InvoicePdfFileInfo> {
        return pdfService.generatePdf(invoice = invoice)
    }
}