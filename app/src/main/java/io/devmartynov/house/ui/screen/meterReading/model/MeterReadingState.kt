package io.devmartynov.house.ui.screen.meterReading.model

import io.devmartynov.house.domain.model.MeterReading
import io.devmartynov.house.ui.shared.model.ActionStatus

data class MeterReadingState(
    val meterReading: MeterReading = MeterReading(),
    val meterReadingStatus: ActionStatus = ActionStatus.Idle,
    val downloadStatus: ActionStatus = ActionStatus.Idle,
)