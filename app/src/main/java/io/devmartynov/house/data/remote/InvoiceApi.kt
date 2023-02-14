package io.devmartynov.house.data.remote

import io.devmartynov.house.data.remote.model.Invoice
import retrofit2.Response
import retrofit2.http.GET

/**
 * API квитанций
 */
interface InvoiceApi {
    /**
     * Получает список квитанций
     *
     * @return список квитанций либо пустой список
     */
    @GET("invoices")
    suspend fun getInvoices(): Response<List<Invoice>>
}