package io.devmartynov.house.ui.screen.main.model

import io.devmartynov.house.domain.model.MeterReadingEntity
import io.devmartynov.house.app.model.ActionStatus

/**
 * Состояние страницы списка показаний счетчика(страница в HorizontalPager)
 *
 * @param meterReadings показания счетчика
 * @param status статус списка показаний
 */
data class MeterReadingsPageState(
    val meterReadings: List<MeterReadingEntity> = emptyList(),
    val status: ActionStatus = ActionStatus.Idle,
)


