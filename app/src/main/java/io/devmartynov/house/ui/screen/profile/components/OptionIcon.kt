package io.devmartynov.house.ui.screen.profile.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import io.devmartynov.house.ui.theme.Blue

@Composable
fun OptionIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    color: Color = Blue,
) {
    Surface(
        modifier = modifier.size(42.dp),
        elevation = 13.dp,
        shape = RoundedCornerShape(10.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(28.dp),
                imageVector = imageVector,
                contentDescription = null,
                tint = color,
            )
        }
    }
}
