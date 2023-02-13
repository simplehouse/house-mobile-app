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
import io.devmartynov.house.domain.model.SubmissionDate
import io.devmartynov.house.domain.model.format
import io.devmartynov.house.ui.shared.Button
import io.devmartynov.house.ui.theme.*

@Composable
fun ServiceStatus(
    modifier: Modifier = Modifier,
    submissionDate: SubmissionDate?,
    isDateExpired: Boolean,
    daysUntilDateExpiration: Int,
    navigateToAddMeterReading: () -> Unit,
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        val title = if (isDateExpired) {
            stringResource(id = R.string.label_submission_date_expired)
        } else if (daysUntilDateExpiration >= 10) {
            stringResource(id = R.string.label_submit_meter_reading)
        } else if (daysUntilDateExpiration >= 5) {
            stringResource(id = R.string.label_submit_meter_reading_until)
        } else if (daysUntilDateExpiration >= 1) {
            stringResource(id = R.string.label_submit_meter_reading_days_count)
        } else {
            stringResource(id = R.string.label_submit_meter_reading)
        }

        Text(
            text = title,
            fontFamily = GilroyFontMedium,
            fontSize = 14.sp,
            lineHeight = 17.sp,
            color = LightGrey100
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = submissionDate?.format("dd.MM.yyyy") ?: "",
            fontFamily = GilroyFontSemibold,
            fontSize = 32.sp,
            lineHeight = 39.sp,
            color = White
        )
        Spacer(modifier = Modifier.height(30.dp))
        if (daysUntilDateExpiration <= 5) {
            Button(
                label = stringResource(id = R.string.cd_enter_reading_meter),
                onClick = navigateToAddMeterReading,
                labelFontSize = 16.sp,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (isDateExpired) Red else Blue,
                    disabledBackgroundColor = if (isDateExpired) LightRed else LightBlue
                )
            )
        } else {
            Text(
                text = stringResource(id = R.string.label_wait_for_submit),
                fontFamily = GilroyFontMedium,
                fontSize = 14.sp,
                lineHeight = 17.sp,
                color = LightGrey100
            )
        }
    }
}