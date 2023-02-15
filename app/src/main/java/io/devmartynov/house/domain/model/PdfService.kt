package io.devmartynov.house.domain.model

import io.devmartynov.house.ui.screen.invoices.model.InvoicePdfFileInfo
import io.devmartynov.house.app.model.Result

/**
 * Сервис генерации pdf документа
 */
interface PdfService {
    /**
     * Генерирует pdf файл и пишет его в /Download директорию
     *
     * @param invoice квитаниция
     * @return имя сгенерированного файла и путь до него
     */
    fun generatePdf(invoice: InvoiceEntity): Result<InvoicePdfFileInfo>
}