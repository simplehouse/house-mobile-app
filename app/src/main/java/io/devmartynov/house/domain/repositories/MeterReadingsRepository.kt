package io.devmartynov.house.domain.repositories

import io.devmartynov.house.domain.model.MeterReading
import io.devmartynov.house.domain.model.Service
import io.devmartynov.house.app.model.Result

/**
 * Репозиторий показаний счетчиков
 */
interface MeterReadingsRepository {
    /**
     * Список показаний счетчика
     *
     * @param service коммунальная услуга по которой запрашивается список показаний
     */
    suspend fun getAll(service: Service): Result<List<MeterReading>>

    /**
     * Сохраняет новое показание счетчика
     *
     * @param value значение по счетчику
     * @param service коммунальная услуга
     */
    suspend fun save(value: Int, service: Service): Result<MeterReading>

    /**
     * Следующая дата подачи показаний счетчика
     */
    suspend fun getNextSubmissionDate(): Result<String>
}