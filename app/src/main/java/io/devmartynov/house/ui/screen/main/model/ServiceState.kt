package io.devmartynov.house.ui.screen.main.model

import io.devmartynov.house.ui.shared.model.ActionStatus

/**
 * Состояние коммунальной услуги
 *
 * @param status
 * @param meterReadings данные о поданных показаниях счетчика
 * @param service коммунальная услуга
 */
data class ServiceState(
    val status: ActionStatus = ActionStatus.Idle,
    val meterReadings: List<MeterReading> = emptyList(),
    val service: Services = Services.GAS
)