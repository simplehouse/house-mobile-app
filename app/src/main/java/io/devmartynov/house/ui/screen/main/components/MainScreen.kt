package io.devmartynov.house.ui.screen.main.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.devmartynov.house.domain.model.MeterReadingEntity
import io.devmartynov.house.domain.model.Service
import io.devmartynov.house.ui.navigation.router.Router
import io.devmartynov.house.ui.screen.main.model.MainScreenEvent
import io.devmartynov.house.ui.screen.main.model.MainScreenState

@Composable
fun MainScreen(
    router: Router,
    uiState: MainScreenState = MainScreenState(),
    handleEvent: (event: MainScreenEvent) -> Unit = {},
    getDaysUntilExpirationSubmissionDate: (service: Service) -> Int = {0},
    isSubmissionDateExpired: (service: Service) -> Boolean = {false},
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
        navigateToMeterReading = { meterReading: MeterReadingEntity ->
            router.navigateToMeterReading(meterReading)
        },
        getDaysUntilExpirationSubmissionDate  = getDaysUntilExpirationSubmissionDate,
        isSubmissionDateExpired = isSubmissionDateExpired,
    )
}