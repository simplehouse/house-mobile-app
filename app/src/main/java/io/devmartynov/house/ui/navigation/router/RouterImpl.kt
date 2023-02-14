package io.devmartynov.house.ui.navigation.router

import androidx.navigation.NavHostController
import io.devmartynov.house.domain.model.MeterReading
import io.devmartynov.house.ui.navigation.model.Route

class RouterImpl(
    private val navController: NavHostController,
) : Router {
    override fun navigateToProfile() {
        navController.navigate(Route.Profile.id)
    }

    override fun navigateToSignIn() {
        navController.navigate(Route.SignIn.id)
    }

    override fun navigateToMeterReadings() {
        navController.navigate(Route.MeterReadings.id)
    }

    override fun navigateToStatistics() {
        navController.navigate(Route.Statistics.id)
    }

    override fun navigateToPasswordRecovery() {
        navController.navigate(Route.PasswordRecovery.id)
    }

    override fun navigateToAddMeterReading(service: Int) {
        navController.navigate(Route.AddMeterReading.buildRoute(service))
    }

    override fun navigateToMeterReading(meterReading: MeterReading) {
        navController.currentBackStackEntry?.savedStateHandle?.set(
            key = Route.MeterReading.PARAM_METER_READING,
            value = meterReading,
        )
        navController.navigate(Route.MeterReading.id)
    }

    override fun navigateToInvoices() {
        navController.navigate(Route.Invoices.id)
    }
}