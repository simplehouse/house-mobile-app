package io.devmartynov.house.ui.screen.auth.signIn.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.devmartynov.house.ui.screen.auth.signIn.model.SignInEvent
import io.devmartynov.house.ui.screen.auth.signIn.model.SignInState
import io.devmartynov.house.ui.shared.ErrorDialog
import io.devmartynov.house.app.model.ActionStatus

@Composable
fun SignInContent(
    modifier: Modifier = Modifier,
    uiState: SignInState,
    handleEvent: (event: SignInEvent) -> Unit,
    handleSignInSuccess: () -> Unit,
) {
    Box(
        modifier = modifier.padding(30.dp),
    ) {
        SignInForm(
            email = uiState.email,
            password = uiState.password,
            isAuthEnabled = uiState.isFormValid(),
            isLoading = uiState.status == ActionStatus.Loading,
            onEmailChanged = { email: String ->
                handleEvent(SignInEvent.EmailChanged(email))
            },
            onPasswordChanged = { password: String ->
                handleEvent(SignInEvent.PasswordChanged(password))
            },
            onSignIn = {
                handleEvent(SignInEvent.SignIn)
            }
        )
        if (uiState.status is ActionStatus.Error) {
            ErrorDialog(
                error = uiState.status.error ?: "",
                dismissError = {
                    handleEvent(SignInEvent.ErrorDismissed)
                }
            )
        }
        if (uiState.status is ActionStatus.Success) {
            LaunchedEffect(uiState) {
                handleSignInSuccess()
            }
        }
    }
}