package io.devmartynov.house.domain.useCase

import io.devmartynov.house.domain.model.MeterReading
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
    suspend operator fun invoke(service: Service): Result<List<MeterReading>> {
        return meterReadingsRepository.getAll(service)
    }
}