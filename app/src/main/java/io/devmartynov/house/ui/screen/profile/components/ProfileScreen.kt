package io.devmartynov.house.ui.screen.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import io.devmartynov.house.ui.screen.profile.ProfileViewModel
import io.devmartynov.house.ui.theme.HouseTheme
import io.devmartynov.house.ui.theme.White

@Composable
fun ProfileScreen() {
    val viewModel: ProfileViewModel = viewModel()

    HouseTheme {
        ProfileContent(
            modifier = Modifier.fillMaxSize().background(color = White),
            profileState = viewModel.uiState.collectAsState().value,
            handleEvent = viewModel::handleEvent
        )
    }
}