package io.devmartynov.house.ui.screen.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.devmartynov.house.R
import io.devmartynov.house.ui.shared.Symbol
import io.devmartynov.house.ui.theme.Blue
import io.devmartynov.house.ui.theme.GilroyFontMedium
import io.devmartynov.house.ui.theme.Red
import io.devmartynov.house.ui.theme.White

@Composable
fun MeterReadingItem(
    modifier: Modifier = Modifier,
    date: String,
    amount: Int,
    isExpired: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .heightIn(75.dp)
            .clickable(
                onClick = onClick,
                onClickLabel = stringResource(id = R.string.cd_look_meter_reading_detail_info)
            )
            .padding(horizontal = 30.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Symbol(
            imageVector = Icons.Default.CalendarMonth,
            tint = if (isExpired) {
                Red
            } else {
                Blue
            }
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.label_meter_reading_create_date, date),
            fontSize = 16.sp,
        )
        Text(
            text = stringResource(id = R.string.label_amount, amount),
            fontFamily = GilroyFontMedium,
            fontSize = 16.sp,
        )
    }
}