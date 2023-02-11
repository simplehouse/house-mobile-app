package io.devmartynov.house.domain.useCase

import io.devmartynov.house.domain.model.Service
import javax.inject.Inject

/**
 * Сценарий добавления нового показания счетчика
 */
class SaveMeterReadingUseCase @Inject constructor(

) {
    /**
     * Добавляет новое показание счетчика
     *
     * @param value значение по счетчику
     * @param service коммунальная услуга по которой подается показание
     */
    suspend operator fun invoke(value: String, service: Service) {

    }
}