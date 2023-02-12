package io.devmartynov.house.ui.screen.main.model

import io.devmartynov.house.app.model.ActionStatus

/**
 * Состояние на главном экране
 *
 * @param gasDate дата следующей подачи показаний счетчика газа
 * @param waterDate дата следующей подачи показаний счетчика воды
 * @param electricityDate дата следующей подачи показаний счетчика электричества
 * @param status статус дат
 */
data class MainScreenState(
    val gasDate: String? = null,
    val waterDate: String? = null,
    val electricityDate: String? = null,
    val status: ActionStatus = ActionStatus.Idle,
)