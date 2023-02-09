package io.devmartynov.house.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.devmartynov.house.ui.theme.*

@Composable
fun OtpTextInput(
    modifier: Modifier = Modifier,
    value: String = "",
    maxCharsCount: Int = 10,
    focusedColor: Color = Black,
    filledColor: Color = Black.copy(alpha = 0.5f),
    notFilledColor: Color = LightGrey,
    onValueChange: (value: String) -> Unit = {},
) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    BasicTextField(
        modifier = modifier.focusRequester(focusRequester),
        value = value,
        onValueChange = {
            if (it.length <= maxCharsCount) {
                onValueChange.invoke(it)
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword
        ),
        decorationBox = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(maxCharsCount) { index ->
                    CharView(
                        index = index,
                        text = value,
                        focusedColor = focusedColor,
                        filledColor = filledColor,
                        notFilledColor = notFilledColor,
                    )
                }
            }
        }
    )
}

@Composable
private fun CharView(
    index: Int,
    text: String,
    focusedColor: Color,
    filledColor: Color,
    notFilledColor: Color,
) {
    val isFocused = text.length == index
    val char = when {
        isFocused -> ""
        index > text.length -> ""
        else -> text[index].toString()
    }
    val color = when {
        isFocused -> focusedColor
        index > text.length -> notFilledColor
        index < text.length -> filledColor
        else -> notFilledColor
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier.width(35.dp),
            text = char,
            style = MaterialTheme.typography.h2,
            color = color,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(3.dp))
        Box(
            modifier = Modifier
                .width(35.dp)
                .height(4.dp)
                .background(
                    color = color,
                    shape = RoundedCornerShape(2.dp)
                )
        )
    }
}