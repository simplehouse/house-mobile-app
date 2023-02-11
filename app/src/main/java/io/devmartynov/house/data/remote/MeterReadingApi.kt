package io.devmartynov.house.data.remote

import io.devmartynov.house.data.remote.model.RemoteMeterReading
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * API сервис для показаний счетчиков
 */
interface MeterReadingApi {

    @GET("/meter-readings")
    suspend fun getMeterReadings(@Query("service") service: Int): Response<List<RemoteMeterReading>>

    @POST("/meter-readings")
    suspend fun saveMeterReading(
        @Field("value") value: Int,
        @Field("service") service: Int
    ): Response<RemoteMeterReading>
}