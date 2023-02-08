package io.devmartynov.house.ui.screen.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.devmartynov.house.R
import io.devmartynov.house.ui.shared.Button
import io.devmartynov.house.ui.theme.GilroyFontMedium
import io.devmartynov.house.ui.theme.GilroyFontSemibold
import io.devmartynov.house.ui.theme.LightGrey100
import io.devmartynov.house.ui.theme.White

@Composable
fun ServiceStatus(
    modifier: Modifier = Modifier,
    meterReadingEnteringDate: String,
    navigateToAddMeterReading: () -> Unit,
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Внести показания счетчика до",
            fontFamily = GilroyFontMedium,
            fontSize = 14.sp,
            lineHeight = 17.sp,
            color = LightGrey100
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = meterReadingEnteringDate,
            fontFamily = GilroyFontSemibold,
            fontSize = 32.sp,
            lineHeight = 39.sp,
            color = White
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            label = stringResource(id = R.string.cd_enter_reading_meter),
            onClick = navigateToAddMeterReading,
            labelFontSize = 16.sp,
        )
    }
}