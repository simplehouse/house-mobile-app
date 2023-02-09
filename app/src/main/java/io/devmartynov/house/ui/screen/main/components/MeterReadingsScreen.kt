package io.devmartynov.house.ui.screen.main.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.devmartynov.house.ui.navigation.router.Router
import io.devmartynov.house.ui.screen.main.model.MeterReadingsEvent
import io.devmartynov.house.ui.screen.main.model.MeterReadingsState

@Composable
fun MeterReadingsScreen(
    router: Router,
    uiState: MeterReadingsState = MeterReadingsState(),
    handleEvent: (event: MeterReadingsEvent) -> Unit = {},
) {
    MeterReadingsContent(
        modifier = Modifier.fillMaxSize(),
        meterReadingsState = uiState,
        handleEvent = handleEvent,
        navigateToProfile = {
            router.navigateToProfile()
        },
        navigateToAddMeterReading = { service: Int ->
            router.navigateToAddMeterReading(service)
        },
        navigateToMeterReading = {meterReadingId: Int ->
            router.navigateToMeterReading(meterReadingId)
        }
    )
}