package io.devmartynov.house.domain.repositories

import io.devmartynov.house.domain.model.InvoiceEntity
import io.devmartynov.house.app.model.Result

/**
 * Репозиторий квитанций
 */
interface InvoicesRepository {
    /**
     * Получает список всех квитанций отсортированных по дате
     */
    suspend fun getAll(): Result<List<InvoiceEntity>>
}