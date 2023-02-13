package io.devmartynov.house.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Показание счетчика
 *
 * @param id уникальный ключ показания
 * @param isSubmissionDateExpired просрочена ли дата подачи показания
 * @param createTime дата подачи показания
 * @param toPayAmount сумма, которую нужно заплатить
 * @param service коммунальная услуга
 * @param diffWithPrevValue разница по значению с прошлым месяцем
 * @param value значение по счетчику на момент подачи
 * @param usageAmount сколько было использовано за этот месяц
 */
@Parcelize
data class MeterReading(
    val id: Int = -1,
    val isSubmissionDateExpired: Boolean = false,
    val createTime: String = "",
    val toPayAmount: Float = 0f,
    val service: Service = Service.GAS,
    val diffWithPrevValue: Float = 0f,
    val value: Float = 0f,
    val usageAmount: Float = 0f,
) : Parcelable
