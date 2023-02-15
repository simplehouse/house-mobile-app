package io.devmartynov.house.ui.screen.invoices.model


/**
 * Данные сгенерированного pdf документа
 *
 * @param fileName имя файла
 * @param filePath путь до файла
 */
data class InvoicePdfFileInfo(
    val fileName: String,
    val filePath: String,
)