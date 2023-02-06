package io.devmartynov.house.ui.screen.auth.signIn

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.devmartynov.house.ui.screen.auth.model.SignInEvent
import io.devmartynov.house.ui.screen.auth.model.SignInState
import io.devmartynov.house.ui.shared.ErrorDialog

@Composable
fun SignInContent(
    modifier: Modifier = Modifier,
    signInState: SignInState,
    handleEvent: (event: SignInEvent) -> Unit,
) {
    Box(
        modifier = modifier.padding(30.dp),
    ) {
        SignInForm(
            email = signInState.email,
            password = signInState.password,
            isAuthEnabled = signInState.isFormValid(),
            isLoading = signInState.isLoading,
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
        signInState.error?.let { error: String ->
            ErrorDialog(
                error = error,
                dismissError = {
                    handleEvent(SignInEvent.ErrorDismissed)
                }
            )
        }
    }
}