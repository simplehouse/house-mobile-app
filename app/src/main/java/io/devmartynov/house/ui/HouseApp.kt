package io.devmartynov.house.ui

import androidx.compose.runtime.Composable
import io.devmartynov.house.ui.app.model.AppState
import io.devmartynov.house.ui.navigation.Navigation
import io.devmartynov.house.ui.theme.HouseTheme

@Composable
fun HouseApp(
    appState: AppState,
    isAuthorized: Boolean = false,
    isDarkTheme: Boolean = false,
) {
    HouseTheme(darkTheme = isDarkTheme) {
        Navigation(
            appState = appState,
            isAuthorized = isAuthorized
        )
    }
}