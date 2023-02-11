package io.devmartynov.house.ui.screen.auth.signIn

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.devmartynov.house.ui.screen.auth.signIn.components.SignInContent
import io.devmartynov.house.ui.screen.auth.signIn.model.SignInEvent
import io.devmartynov.house.ui.screen.auth.signIn.model.SignInState

@Composable
fun SignInScreen(
    uiState: SignInState = SignInState(),
    handleEvent: (event: SignInEvent) -> Unit,
    handleSignInSuccess: () -> Unit,
) {
    SignInContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        handleEvent = handleEvent,
        handleSignInSuccess = handleSignInSuccess,
    )
}