package io.devmartynov.house.ui.navigation

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.bottomSheet
import io.devmartynov.house.ui.navigation.model.Route
import io.devmartynov.house.ui.navigation.model.RoutesGroup
import io.devmartynov.house.ui.screen.main.MeterReadingsViewModel
import io.devmartynov.house.ui.screen.main.components.MeterReadingsScreen
import io.devmartynov.house.ui.screen.profile.ProfileViewModel
import io.devmartynov.house.ui.screen.profile.components.ProfileScreen
import io.devmartynov.house.ui.navigation.router.Router
import io.devmartynov.house.ui.screen.addMeterReading.AddMeterReadingViewModel
import io.devmartynov.house.ui.screen.addMeterReading.components.AddMeterReadingScreen
import io.devmartynov.house.ui.screen.auth.passwordRecovery.PasswordRecoveryViewModel
import io.devmartynov.house.ui.screen.auth.passwordRecovery.components.PasswordRecoveryScreen
import io.devmartynov.house.ui.screen.meterReading.MeterReadingViewModel
import io.devmartynov.house.ui.screen.meterReading.components.MeterReadingScreen
import io.devmartynov.house.ui.screen.statistics.components.StatisticsScreen

@OptIn(ExperimentalMaterialNavigationApi::class)
fun NavGraphBuilder.mainGraph(router: Router) {
    navigation(
        route = RoutesGroup.MAIN.id,
        startDestination = Route.MeterReadings.id,
    ) {
        composable(Route.MeterReadings.id) {
            val viewModel = hiltViewModel<MeterReadingsViewModel>()
            val uiState = viewModel.uiState.collectAsState().value

            MeterReadingsScreen(
                router = router,
                uiState = uiState,
                handleEvent = viewModel::handleEvent,
            )
        }
        composable(Route.Profile.id) {
            val viewModel = hiltViewModel<ProfileViewModel>()
            val uiState = viewModel.uiState.collectAsState().value

            ProfileScreen(
                router = router,
                uiState = uiState,
                handleEvent = viewModel::handleEvent,
            )
        }
        composable(Route.Statistics.id) {
            val viewModel = hiltViewModel<PasswordRecoveryViewModel>()

            StatisticsScreen()
        }
        composable(Route.PasswordRecovery.id) {
            val viewModel = hiltViewModel<PasswordRecoveryViewModel>()

            PasswordRecoveryScreen()
        }
        bottomSheet(
            route = Route.AddMeterReading.id,
            arguments = Route.AddMeterReading.navArguments,
        ) {
            val viewModel = hiltViewModel<AddMeterReadingViewModel>()

            AddMeterReadingScreen(
                uiState = viewModel.uiState.collectAsState().value,
                handleEvent = viewModel::handleEvent,
                navigateToMeterReadings = {
                    router.navigateToMetersReading()
                }
            )
        }
        bottomSheet(
            route = Route.MeterReading.id,
            arguments = Route.MeterReading.navArguments,
        ) {
            val viewModel = hiltViewModel<MeterReadingViewModel>()

            MeterReadingScreen()
        }
    }
}