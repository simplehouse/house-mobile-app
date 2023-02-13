package io.devmartynov.house.domain.useCase

import io.devmartynov.house.domain.repositories.MeterReadingsRepository
import javax.inject.Inject
import io.devmartynov.house.app.model.Result

/**
 * Сценарий получения следующей даты подачи показаний счетчика
 *
 * @param meterReadingsRepository репозиторий показаний счетчика
 */
class GetMeterReadingDateUseCase @Inject constructor(
    private val meterReadingsRepository: MeterReadingsRepository,
) {

    suspend operator fun invoke(): Result<Long> {
        return meterReadingsRepository.getNextSubmissionDate()
    }
}