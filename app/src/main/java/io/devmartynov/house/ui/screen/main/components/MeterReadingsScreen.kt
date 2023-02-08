package io.devmartynov.house.ui.screen.main.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import io.devmartynov.house.ui.screen.main.MeterReadingsViewModel
import io.devmartynov.house.ui.theme.HouseTheme

@Composable
fun MeterReadingsScreen() {
    val viewModel: MeterReadingsViewModel = viewModel()

    HouseTheme {
        MeterReadingsContent(
            modifier = Modifier.fillMaxSize(),
            meterReadingsState = viewModel.uiState.collectAsState().value,
            handleEvent = viewModel::handleEvent,
        )
    }
}