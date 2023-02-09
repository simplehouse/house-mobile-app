package io.devmartynov.house.ui.screen.addMeterReading.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.devmartynov.house.ui.theme.Red

@Composable
fun AddMeterReadingContent(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.background(color = Red))
}