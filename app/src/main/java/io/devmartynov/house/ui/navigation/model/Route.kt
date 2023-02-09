package io.devmartynov.house.ui.navigation.model

import androidx.navigation.NavType
import androidx.navigation.navArgument

/**
 * Экраны приложения
 *
 * @see io.devmartynov.house.ui.navigation.Navigation
 */
sealed class Route(val baseId: String) {
    open val id: String = baseId

    object SignIn : Route("sign_in")
    object PasswordRecovery : Route("password_recovery")
    object Profile : Route("profile")
    object MeterReadings : Route("meter_readings")
    object Statistics : Route("statistics")
    object AddMeterReading : Route("add_meter_reading") {
        const val PARAM_METER_READING_SERVICE = "service"
        override val id = "$baseId/{$PARAM_METER_READING_SERVICE}"

        val navArguments = listOf(
            navArgument(PARAM_METER_READING_SERVICE) {
                type = NavType.IntType
                nullable = false
            }
        )

        fun buildRoute(service: Int): String {
            return "$baseId/$service"
        }
    }

    object MeterReading : Route("meter_reading") {
        const val PARAM_METER_READING_ID = "id"
        override val id = "$baseId/{$PARAM_METER_READING_ID}"

        val navArguments = listOf(
            navArgument(PARAM_METER_READING_ID) {
                type = NavType.IntType
                nullable = false
            }
        )

        fun buildRoute(meterReadingId: Int): String {
            return "$baseId/$meterReadingId"
        }
    }
}