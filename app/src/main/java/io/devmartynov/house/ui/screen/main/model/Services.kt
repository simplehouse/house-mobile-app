package io.devmartynov.house.ui.screen.main.model

import androidx.annotation.StringRes
import io.devmartynov.house.R

/**
 * Услуги
 *
 * @param label название услуги
 */
enum class Services(
    @StringRes val label: Int,
) {
    GAS(R.string.label_service_gas),
    WATER(R.string.label_service_water),
    ELECTRICITY(R.string.label_service_electricity),
}