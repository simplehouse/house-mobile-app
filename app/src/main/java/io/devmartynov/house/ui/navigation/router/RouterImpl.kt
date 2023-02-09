package io.devmartynov.house.ui.navigation.router

import androidx.navigation.NavHostController
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

    override fun navigateToMetersReading() {
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

    override fun navigateToMeterReading(id: Int) {
        navController.navigate(Route.MeterReading.buildRoute(id))
    }
}