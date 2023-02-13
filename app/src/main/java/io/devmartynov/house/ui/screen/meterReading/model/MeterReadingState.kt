package io.devmartynov.house.ui.screen.meterReading.model

import io.devmartynov.house.app.model.ActionStatus

/**
 * Состояние экрана(боттом щит диалог) детальной информации показания счетчика
 *
 * @param downloadStatus статус загрузки квитанции об оплате коммунальных услуг
 */
data class MeterReadingState(
    val downloadStatus: ActionStatus = ActionStatus.Idle,
)