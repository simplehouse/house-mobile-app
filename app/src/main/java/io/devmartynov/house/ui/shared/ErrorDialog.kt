package io.devmartynov.house.ui.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import io.devmartynov.house.R

@Composable
fun ErrorDialog(
    modifier: Modifier = Modifier,
    error: String,
    dismissError: () -> Unit,
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            dismissError()
        },
        buttons = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                TextButton(onClick = {
                    dismissError()
                }) {
                    Text(text = stringResource(id = R.string.error_action))
                }
            }
        },
        title = {
            Text(
                text = stringResource(id = R.string.error_title),
                fontSize = 18.sp,
            )
        },
        text = {
            Text(
                text = error,
            )
        },
    )
}