package io.devmartynov.house.ui.screen.main.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.devmartynov.house.ui.navigation.router.Router
import io.devmartynov.house.ui.screen.main.model.MainScreenEvent
import io.devmartynov.house.ui.screen.main.model.MainScreenState

@Composable
fun MainScreen(
    router: Router,
    uiState: MainScreenState = MainScreenState(),
    handleEvent: (event: MainScreenEvent) -> Unit = {},
) {
    MainScreenContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        handleEvent = handleEvent,
        navigateToProfile = {
            router.navigateToProfile()
        },
        navigateToAddMeterReading = { service: Int ->
            router.navigateToAddMeterReading(service)
        },
        navigateToMeterReading = { meterReadingId: Int ->
            router.navigateToMeterReading(meterReadingId)
        }
    )
}