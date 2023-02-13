package io.devmartynov.house.ui.screen.main.model

import io.devmartynov.house.app.model.ActionStatus
import io.devmartynov.house.domain.model.SubmissionDate

/**
 * Состояние на главном экране
 *
 * @param gasDate дата следующей подачи показаний счетчика газа
 * @param waterDate дата следующей подачи показаний счетчика воды
 * @param electricityDate дата следующей подачи показаний счетчика электричества
 * @param status статус дат
 */
data class MainScreenState(
    val gasDate: SubmissionDate? = null,
    val waterDate: SubmissionDate? = null,
    val electricityDate: SubmissionDate? = null,
    val status: ActionStatus = ActionStatus.Idle,
)