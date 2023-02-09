package io.devmartynov.house.ui.app.model

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import io.devmartynov.house.ui.navigation.router.Router
import io.devmartynov.house.ui.navigation.router.RouterImpl

data class AppState constructor(
    val navController: NavHostController,
    val router: Router,
)

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController()
): AppState {
    return AppState(
        router = RouterImpl(navController),
        navController = navController,
    )
}