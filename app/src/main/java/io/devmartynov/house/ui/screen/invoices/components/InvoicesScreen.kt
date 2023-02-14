package io.devmartynov.house.ui.screen.invoices.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.devmartynov.house.ui.screen.invoices.model.InvoicesEvent
import io.devmartynov.house.ui.screen.invoices.model.InvoicesState

@Composable
fun InvoicesScreen(
    uiState: InvoicesState = InvoicesState(),
    handleEvent: (event: InvoicesEvent) -> Unit = {},
    navigateToPrevScreen: () -> Unit = {},
) {

    InvoicesContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        handleEvent = handleEvent,
        onBackPressed = navigateToPrevScreen,
    )
}