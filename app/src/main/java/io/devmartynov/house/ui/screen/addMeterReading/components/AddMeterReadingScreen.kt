package io.devmartynov.house.ui.screen.addMeterReading.components

import androidx.compose.runtime.Composable
import io.devmartynov.house.ui.screen.addMeterReading.model.AddMeterReadingEvent
import io.devmartynov.house.ui.screen.addMeterReading.model.AddMeterReadingState

@Composable
fun AddMeterReadingScreen(
    uiState: AddMeterReadingState = AddMeterReadingState(),
    handleEvent: (event: AddMeterReadingEvent) -> Unit = {},
    navigateToMeterReadings: () -> Unit = {},
) {
    AddMeterReadingContent(
        uiState = uiState,
        handleEvent = handleEvent,
        navigateToMeterReadings = navigateToMeterReadings,
    )
}