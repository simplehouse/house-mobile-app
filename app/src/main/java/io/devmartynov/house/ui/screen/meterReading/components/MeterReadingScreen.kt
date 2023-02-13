package io.devmartynov.house.ui.screen.meterReading.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import io.devmartynov.house.domain.model.MeterReading
import io.devmartynov.house.ui.navigation.model.Route
import io.devmartynov.house.ui.screen.meterReading.model.MeterReadingEvent
import io.devmartynov.house.ui.screen.meterReading.model.MeterReadingState

@Composable
fun MeterReadingScreen(
    previousBackStack: NavBackStackEntry?,
    uiState: MeterReadingState,
    navigateToInvoicePreview: () -> Unit,
    addMeterReading: (meterReading: MeterReading) -> Unit,
    handleEvent: (event: MeterReadingEvent) -> Unit,
) {
    val meterReading = Route.MeterReading.getMeterReading(previousBackStack)
        ?: throw java.lang.IllegalArgumentException(
            "No meter reading found in previous back stack entry in MeterReadingScreen"
        )
    addMeterReading(meterReading)

    MeterReadingContent(
        meterReading = meterReading,
        uiState = uiState,
        navigateToInvoicePreview = navigateToInvoicePreview,
    )
}