package io.devmartynov.house.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.devmartynov.house.ui.theme.LightGrey100

@Composable
fun Divider(
    modifier: Modifier = Modifier,
    color: Color = LightGrey100,
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp,
    endIndent: Dp = 0.dp,
) {
    Box(
        modifier
            .then(Modifier.padding(start = startIndent, end = endIndent))
            .fillMaxWidth()
            .height(thickness)
            .background(color = color)
    )
}