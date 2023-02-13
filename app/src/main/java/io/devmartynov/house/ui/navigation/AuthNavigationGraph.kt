package io.devmartynov.house.ui.navigation

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import io.devmartynov.house.ui.navigation.model.Route
import io.devmartynov.house.ui.navigation.model.RoutesGroup
import io.devmartynov.house.ui.screen.auth.signIn.SignInViewModel
import io.devmartynov.house.ui.screen.auth.signIn.SignInScreen
import io.devmartynov.house.ui.navigation.router.Router

fun NavGraphBuilder.authGraph(router: Router) {
    navigation(
        route = RoutesGroup.AUTH.id,
        startDestination = Route.SignIn.id,
    ) {
        composable(Route.SignIn.id) {
            val viewModel = hiltViewModel<SignInViewModel>()
            val signInState = viewModel.uiState.collectAsState().value

            SignInScreen(
                uiState = signInState,
                handleEvent = viewModel::handleEvent,
                handleSignInSuccess = router::navigateToMeterReadings
            )
        }
    }
}