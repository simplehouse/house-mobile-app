package io.devmartynov.house.ui.screen.auth.signIn

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.devmartynov.house.R
import io.devmartynov.house.ui.shared.Button
import io.devmartynov.house.ui.shared.EmailInput
import io.devmartynov.house.ui.shared.PasswordInput

@Composable
fun SignInForm(
    modifier: Modifier = Modifier,
    email: String?,
    password: String?,
    isAuthEnabled: Boolean,
    isLoading: Boolean,
    onEmailChanged: (email: String) -> Unit,
    onPasswordChanged: (password: String) -> Unit,
    onSignIn: () -> Unit,
) {
    Column(
        modifier = modifier,
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.label_sign_in_to_account),
            style = MaterialTheme.typography.h1,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(R.string.sign_in_to_account_hint),
            style = MaterialTheme.typography.subtitle1,
        )
        Spacer(modifier = Modifier.height(70.dp))
        val passwordFocusRequester = FocusRequester()

        Column {
            EmailInput(
                modifier = Modifier.fillMaxWidth(),
                email = email ?: "",
                onEmailChanged = onEmailChanged,
                onNextClicked = {
                    passwordFocusRequester.requestFocus()
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            PasswordInput(
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(passwordFocusRequester),
                password = password ?: "",
                onPasswordChanged = onPasswordChanged,
                onDoneClicked = {
                    if (isAuthEnabled) {
                        onSignIn()
                    }
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.action_sign_in),
            onClick = onSignIn,
            isLoading = isLoading,
            enabled = isAuthEnabled,
        )
    }
}