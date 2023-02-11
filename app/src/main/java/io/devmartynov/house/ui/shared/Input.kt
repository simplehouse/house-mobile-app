package io.devmartynov.house.ui.shared

import androidx.compose.foundation.border
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.devmartynov.house.ui.theme.*

@Composable
fun Input(
    modifier: Modifier = Modifier,
    singleLine: Boolean = true,
    value: String = "",
    isError: Boolean = false,
    enabled: Boolean = true,
    onValueChange: (value: String) -> Unit = {},
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    label: @Composable (() -> Unit)? = {},
    leadingIcon: @Composable (() -> Unit)? = {},
    trailingIcon: @Composable (() -> Unit)? = {},
) {
    TextField(
        modifier = modifier.border(
            width = 1.dp,
            color = if (isError) Red else Color.Transparent,
            shape = Shapes.medium
        ),
        enabled = enabled,
        singleLine = singleLine,
        value = value,
        onValueChange = onValueChange,
        isError = isError,
        label = label,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        shape = MaterialTheme.shapes.medium,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Black,
            backgroundColor = LightGrey,
            leadingIconColor = Blue,
            trailingIconColor = Blue,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            errorLeadingIconColor = Red,
            errorTrailingIconColor = Red,
            errorLabelColor = Red,
        ),
        textStyle = TextStyle(
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal,
            fontFamily = GilroyFontMedium,
            textDecoration = null,
        ),
    )
}