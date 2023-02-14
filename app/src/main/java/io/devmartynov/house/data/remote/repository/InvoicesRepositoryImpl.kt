package io.devmartynov.house.data.remote.repository

import io.devmartynov.house.data.remote.mappers.toDomainModel
import io.devmartynov.house.app.model.Result
import io.devmartynov.house.data.remote.InvoiceApi
import io.devmartynov.house.domain.model.InvoiceEntity
import io.devmartynov.house.domain.repositories.InvoicesRepository
import javax.inject.Inject

class InvoicesRepositoryImpl @Inject constructor(
    private val invoiceApi: InvoiceApi,
) : InvoicesRepository {
    override suspend fun getAll(): Result<List<InvoiceEntity>> {
        try {
            val response = invoiceApi.getInvoices()
            if (response.isSuccessful) {
                if (response.body() == null) {
                    return Result.Failure(response.errorBody().toString())
                }
                val list = response.body()!!.map { it.toDomainModel() }
                return Result.Success(list)
            }
            return Result.Failure(
                "Error while getting invoices. Error: ${response.errorBody().toString()}"
            )
        } catch (e: Exception) {
            return Result.Failure(e.message.toString())
        }
    }
}