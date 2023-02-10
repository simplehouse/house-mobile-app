package io.devmartynov.house.domain.model

import androidx.annotation.StringRes
import io.devmartynov.house.R

/**
 * Коммунальная услуга
 *
 * @param label название услуги
 */
enum class Service(
    @StringRes val label: Int,
) {
    GAS(R.string.label_service_gas),
    WATER(R.string.label_service_water),
    ELECTRICITY(R.string.label_service_electricity),
}