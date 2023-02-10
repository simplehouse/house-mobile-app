package io.devmartynov.house.ui.screen.main.model

import io.devmartynov.house.domain.model.MeterReading
import io.devmartynov.house.ui.shared.model.ActionStatus

/**
 * Состояние страницы списка показаний счетчика(страница в HorizontalPager)
 *
 * @param meterReadings показания счетчика
 * @param status статус списка показаний
 */
data class MeterReadingsPageState(
    val meterReadings: List<MeterReading> = emptyList(),
    val status: ActionStatus = ActionStatus.Idle,
)


