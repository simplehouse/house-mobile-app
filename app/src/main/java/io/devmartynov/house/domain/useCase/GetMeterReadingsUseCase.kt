package io.devmartynov.house.domain.useCase

import io.devmartynov.house.domain.model.MeterReadingEntity
import io.devmartynov.house.domain.model.Service
import io.devmartynov.house.domain.repositories.MeterReadingsRepository
import javax.inject.Inject
import io.devmartynov.house.app.model.Result

/**
 * Сценарий получения показаний счетчика
 *
 * @param meterReadingsRepository репозиторий показаний счетчиков
 */
class GetMeterReadingsUseCase @Inject constructor(
    private val meterReadingsRepository: MeterReadingsRepository,
) {
    suspend operator fun invoke(service: Service): Result<List<MeterReadingEntity>> {
        return meterReadingsRepository.getAll(service)
    }
}