package io.devmartynov.house.data.remote.repository

import io.devmartynov.house.data.remote.MeterReadingApi
import io.devmartynov.house.data.remote.mappers.toDomainModel
import io.devmartynov.house.domain.model.MeterReading
import io.devmartynov.house.domain.model.Service
import io.devmartynov.house.domain.repositories.MeterReadingsRepository
import io.devmartynov.house.app.model.Result
import io.devmartynov.house.domain.model.SubmissionDate
import java.io.IOException
import javax.inject.Inject

class MeterReadingsRepositoryImpl @Inject constructor(
    private val meterReadingApi: MeterReadingApi,
) : MeterReadingsRepository {
    override suspend fun getAll(service: Service): Result<List<MeterReading>> {
        try {
            val response = meterReadingApi.getMeterReadings(service.ordinal)
            if (response.isSuccessful) {
                if (response.body() == null) {
                    return Result.Failure(response.errorBody().toString())
                }
                val list = response.body()!!.map { it.toDomainModel() }
                return Result.Success(list)
            }
            return Result.Failure(
                "Error while getting meter readings by service: ${service.label}. Error: ${
                    response.errorBody().toString()
                }"
            )
        } catch (e: Exception) {
            return Result.Failure(e.message.toString())
        }
    }

    override suspend fun save(value: Int, service: Service): Result<MeterReading> {
        try {
            val response = meterReadingApi.saveMeterReading(value, service.ordinal)

            if (response.isSuccessful) {
                if (response.body() == null) {
                    return Result.Failure(response.errorBody().toString())
                }
                return Result.Success(response.body()!!.toDomainModel())
            }
            return Result.Failure(
                "Error while saving meter reading with value: $value and service: ${service.label}. Error: ${
                    response.errorBody().toString()
                }"
            )
        } catch (e: Exception) {
            return Result.Failure(e.message.toString())
        }
    }

    override suspend fun getNextSubmissionDate(): Result<SubmissionDate> {
        try {
            val response = meterReadingApi.getNextSubmissionDate()

            if (response.isSuccessful) {
                if (response.body() == null) {
                    return Result.Failure(response.errorBody().toString())
                }
                return Result.Success(response.body()!!.toDomainModel())
            }
            return Result.Failure(
                "Error while getting next submission date: ${response.errorBody().toString()}"
            )
        } catch (e: IOException) {
            return Result.Failure(e.message.toString())
        }
    }
}