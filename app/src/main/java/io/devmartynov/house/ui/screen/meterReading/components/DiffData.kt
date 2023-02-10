package io.devmartynov.house.ui.screen.meterReading.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.devmartynov.house.ui.theme.Green
import io.devmartynov.house.ui.theme.Red

@Composable
fun DiffData(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    isPositive: Boolean,
) {
    Row(
        modifier = modifier.heightIn(65.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            fontSize = 16.sp,
        )
        Icon(
            imageVector = if (isPositive) {
                Icons.Default.ArrowUpward
            } else {
                Icons.Default.ArrowUpward
            },
            tint = if (isPositive) {
                Green
            } else {
                Red
            },
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(3.dp))
        Text(
            text = value,
            fontSize = 16.sp,
        )
    }
}