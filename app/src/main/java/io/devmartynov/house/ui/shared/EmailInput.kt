package io.devmartynov.house.ui.shared

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import io.devmartynov.house.R

@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    email: String?,
    enabled: Boolean = true,
    onEmailChanged: (email: String) -> Unit,
    onNextClicked: () -> Unit,
) {
    Input(
        modifier = modifier,
        value = email ?: "",
        enabled = enabled,
        onValueChange = onEmailChanged,
        label = {
            Text(text = stringResource(id = R.string.label_email))
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
            )
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email,
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                onNextClicked()
            }
        )
    )
}