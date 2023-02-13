package io.devmartynov.house.ui.screen.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.devmartynov.house.ui.navigation.router.Router
import io.devmartynov.house.ui.screen.profile.model.ProfileEvent
import io.devmartynov.house.ui.screen.profile.model.ProfileState
import io.devmartynov.house.ui.theme.White

@Composable
fun ProfileScreen(
    router: Router,
    uiState: ProfileState = ProfileState(),
    handleEvent: (event: ProfileEvent) -> Unit = {},
) {
    ProfileContent(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White),
        profileState = uiState,
        handleEvent = handleEvent,
        navigateToStatistics = {
            router.navigateToStatistics()
        },
        navigateToPasswordRecovery = {
            router.navigateToPasswordRecovery()
        },
        navigateToMetersReading = {
            router.navigateToMeterReadings()
        },
    )
}