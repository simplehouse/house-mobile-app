package io.devmartynov.house.domain.repositories

import io.devmartynov.house.domain.model.MeterReadingEntity
import io.devmartynov.house.domain.model.Service
import io.devmartynov.house.app.model.Result
import io.devmartynov.house.domain.model.SubmissionDateEntity

/**
 * Репозиторий показаний счетчиков
 */
interface MeterReadingsRepository {
    /**
     * Список показаний счетчика
     *
     * @param service коммунальная услуга по которой запрашивается список показаний
     */
    suspend fun getAll(service: Service): Result<List<MeterReadingEntity>>

    /**
     * Сохраняет новое показание счетчика
     *
     * @param value значение по счетчику
     * @param service коммунальная услуга
     */
    suspend fun save(value: Int, service: Service): Result<MeterReadingEntity>

    /**
     * Следующая дата подачи показаний счетчика
     *
     * @return timestamp
     */
    suspend fun getNextSubmissionDate(): Result<SubmissionDateEntity>
}