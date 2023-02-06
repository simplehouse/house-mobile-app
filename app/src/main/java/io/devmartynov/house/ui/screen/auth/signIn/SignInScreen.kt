package io.devmartynov.house.ui.screen.auth.signIn

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import io.devmartynov.house.ui.screen.auth.SignInViewModel
import io.devmartynov.house.ui.theme.HouseTheme

@Composable
fun SignInScreen() {
    val viewModel: SignInViewModel = viewModel()

    HouseTheme {
        SignInContent(
            modifier = Modifier.fillMaxSize(),
            signInState = viewModel.uiState.collectAsState().value,
            handleEvent = viewModel::handleEvent
        )
    }
}