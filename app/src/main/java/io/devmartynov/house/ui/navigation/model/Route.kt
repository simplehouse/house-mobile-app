package io.devmartynov.house.ui.navigation.model

import androidx.navigation.NavBackStackEntry
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
        const val PARAM_METER_READING = "meter_reading"

        fun getMeterReading(backStackEntry: NavBackStackEntry?): io.devmartynov.house.domain.model.MeterReading? {
            if (backStackEntry == null) {
                return null
            }
            return backStackEntry
                .savedStateHandle
                .get<io.devmartynov.house.domain.model.MeterReading>(PARAM_METER_READING)
        }
    }

    /**
     * Экран списка квитанций об оплате коммунальных платежей
     */
    object Invoices : Route("invoices")
}