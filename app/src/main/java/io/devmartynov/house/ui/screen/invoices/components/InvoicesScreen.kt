package io.devmartynov.house.ui.screen.invoices.components

import android.Manifest
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import io.devmartynov.house.domain.model.InvoiceEntity
import io.devmartynov.house.ui.screen.invoices.model.InvoiceAction
import io.devmartynov.house.ui.screen.invoices.model.InvoicesEvent
import io.devmartynov.house.ui.screen.invoices.model.InvoicesState
import io.devmartynov.house.ui.screen.invoices.model.InvoicePdfFileInfo

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun InvoicesScreen(
    uiState: InvoicesState = InvoicesState(),
    handleEvent: (event: InvoicesEvent) -> Unit = {},
    navigateToPrevScreen: () -> Unit = {},
) {
    val permissionsState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
        )
    )
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit, block = {
        if (!permissionsState.allPermissionsGranted) {
            permissionsState.launchMultiplePermissionRequest()
        }
    })

    LaunchedEffect(key1 = uiState, block = {
        if (uiState.invoiceDownloadedStatus.isSuccessful()) {
            val data = uiState.invoiceDownloadedStatus.getSuccessfulData()
                    as InvoicePdfFileInfo

            val text = "Файл ${data.fileName} загружен в ${data.filePath}"
            Toast.makeText(context, text, Toast.LENGTH_LONG).show()
            handleEvent(InvoicesEvent.InvoiceDownloadedIdle)
        }
    })

    InvoicesContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        isPermissionGranted = permissionsState.allPermissionsGranted,
        onBackPressed = navigateToPrevScreen,
        onOptionSelected = { action: InvoiceAction, invoice: InvoiceEntity ->
            when (action) {
                InvoiceAction.DOWNLOAD -> {
                    if (permissionsState.allPermissionsGranted) {
                        handleEvent(InvoicesEvent.InvoiceDownloaded(invoice))
                    } else {
                        permissionsState.launchMultiplePermissionRequest()
                    }
                }
                InvoiceAction.SHARE -> {
                    // todo implement
                }
                InvoiceAction.VIEW -> {
                    // todo implement
                }
            }
        }
    )
}