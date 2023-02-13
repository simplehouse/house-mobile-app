package io.devmartynov.house.ui.screen.meterReading.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.devmartynov.house.R
import io.devmartynov.house.ui.screen.meterReading.model.MeterReadingState

@Composable
fun MeterReadingContent(
    modifier: Modifier = Modifier,
    uiState: MeterReadingState = MeterReadingState(),
    navigateToInvoicePreview: () -> Unit,
) {
    Column(
        modifier = modifier.padding(
            top = 35.dp,
            bottom = 30.dp,
        ),
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 30.dp),
            text = stringResource(id = R.string.label_meter_reading),
            style = MaterialTheme.typography.h2,
        )
        MeterReadingInfo(
            value = uiState.meterReading.value,
            createDate = uiState.meterReading.createTime,
            isExpired = uiState.meterReading.isSubmissionDateExpired,
            toPayAmount = uiState.meterReading.toPayAmount,
            diffWithPrevValue = uiState.meterReading.diffWithPrevValue,
            usageAmount = uiState.meterReading.usageAmount
        )
        Controls(
            modifier = Modifier.fillMaxWidth(),
            uiState = uiState,
            navigateToInvoicePreview = navigateToInvoicePreview,
            onShareClick = {},
            onDownloadClick = {},
        )
    }
}