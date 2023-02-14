package io.devmartynov.house.domain.useCase

import javax.inject.Inject
import io.devmartynov.house.app.model.Result
import io.devmartynov.house.domain.model.InvoiceEntity
import io.devmartynov.house.domain.repositories.InvoicesRepository

/**
 * Сценарий получения квитанций
 *
 * @param invoicesRepository репозиторий квитанций
 */
class GetInvoicesUseCase @Inject constructor(
    private val invoicesRepository: InvoicesRepository,
) {
    suspend operator fun invoke(): Result<List<InvoiceEntity>> {
        return invoicesRepository.getAll()
    }
}