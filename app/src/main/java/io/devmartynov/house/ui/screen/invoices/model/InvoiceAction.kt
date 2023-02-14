package io.devmartynov.house.ui.screen.invoices.model

import androidx.annotation.StringRes
import io.devmartynov.house.R

/**
 * Действия которые можно совершить с квитанцией
 *
 * @param label имя действия
 */
enum class InvoiceAction(
    @StringRes val label: Int,
) {
    /**
     * Просмотр
     */
    VIEW(R.string.label_see_invoice),

    /**
     * Поделиться
     */
    SHARE(R.string.label_share_invoice),

    /**
     * Скачать
     */
    DOWNLOAD(R.string.label_download_invoice),
}