package io.devmartynov.house.ui.screen.meterReading.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.devmartynov.house.R
import io.devmartynov.house.ui.screen.meterReading.model.MeterReadingState
import io.devmartynov.house.ui.shared.Button
import io.devmartynov.house.ui.shared.ControlsNav

@Composable
fun Controls(
    modifier: Modifier = Modifier,
    uiState: MeterReadingState,
    navigateToInvoicePreview: () -> Unit,
    onShareClick: () -> Unit,
    onDownloadClick: () -> Unit,
) {
    ControlsNav(modifier = modifier) {
        Button(
            imageVector = Icons.Default.RemoveRedEye,
            enabled = true,
            label = stringResource(id = R.string.label_see_invoice),
            onClick = {
                navigateToInvoicePreview()
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            imageVector = Icons.Default.Share,
            enabled = true,
            label = stringResource(id = R.string.label_share_invoice),
            onClick = {
                onShareClick()
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            imageVector = Icons.Default.Download,
            enabled = !uiState.downloadStatus.isLoading(),
            isLoading = uiState.downloadStatus.isLoading(),
            label = stringResource(id = R.string.label_download_invoice),
            onClick = {
                onDownloadClick()
            }
        )
    }
}