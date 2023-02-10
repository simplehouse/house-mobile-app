package io.devmartynov.house.ui.screen.meterReading.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import io.devmartynov.house.ui.navigation.model.Route

@Composable
fun MeterReadingScreen(
    navBackStackEntry: NavBackStackEntry,
    navigateToInvoicePreview: () -> Unit,
) {
    val meterReadingId = Route.MeterReading.getMeterReadingId(navBackStackEntry)

    MeterReadingContent(
        navigateToInvoicePreview = navigateToInvoicePreview,
    )
}