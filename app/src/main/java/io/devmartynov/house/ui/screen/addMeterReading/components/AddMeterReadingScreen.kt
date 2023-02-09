package io.devmartynov.house.ui.screen.addMeterReading.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.devmartynov.house.ui.screen.addMeterReading.model.AddMeterReadingEvent
import io.devmartynov.house.ui.screen.addMeterReading.model.AddMeterReadingState

@Composable
fun AddMeterReadingScreen(
    uiState: AddMeterReadingState = AddMeterReadingState(),
    handleEvent: (event: AddMeterReadingEvent) -> Unit,
    navigateToMeterReadings: () -> Unit,
) {
    AddMeterReadingContent(
        modifier = Modifier.fillMaxSize().heightIn(300.dp)
    )
}