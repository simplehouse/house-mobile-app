package io.devmartynov.house.ui.screen.main.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import io.devmartynov.house.domain.model.MeterReading
import io.devmartynov.house.domain.model.Service
import io.devmartynov.house.ui.screen.main.MeterReadingsPageViewModel

@Composable
fun MeterReadingsPage(
    modifier: Modifier = Modifier,
    service: Service,
    onMeterReadingClick: (meterReading: MeterReading) -> Unit = {},
) {
    val viewModel: MeterReadingsPageViewModel = hiltViewModel(key = service.ordinal.toString())
    val uiState = viewModel.uiState.collectAsState().value
    viewModel.service = service

    MeterReadingsList(
        modifier = modifier,
        meterReadings = uiState.meterReadings,
        service = service,
        isLoading = uiState.status.isLoading(),
        onMeterReadingClick = onMeterReadingClick
    )
}