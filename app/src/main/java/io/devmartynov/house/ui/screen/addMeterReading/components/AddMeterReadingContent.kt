package io.devmartynov.house.ui.screen.addMeterReading.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import io.devmartynov.house.R
import io.devmartynov.house.ui.screen.addMeterReading.model.AddMeterReadingEvent
import io.devmartynov.house.ui.screen.addMeterReading.model.AddMeterReadingState
import io.devmartynov.house.ui.screen.addMeterReading.model.METER_READING_VALUE_MIN_LENGTH
import io.devmartynov.house.ui.screen.auth.signIn.model.SignInEvent
import io.devmartynov.house.ui.shared.Button
import io.devmartynov.house.ui.shared.ErrorDialog
import io.devmartynov.house.ui.shared.OtpTextInput
import io.devmartynov.house.ui.shared.model.ActionStatus
import io.devmartynov.house.ui.theme.*

@Composable
fun AddMeterReadingContent(
    modifier: Modifier = Modifier,
    uiState: AddMeterReadingState,
    handleEvent: (event: AddMeterReadingEvent) -> Unit,
    navigateToMeterReadings: () -> Unit,
) {
    TopAppBar(
        modifier = Modifier.zIndex(1f),
        backgroundColor = MaterialTheme.colors.surface,
        contentPadding = PaddingValues(start = 15.dp),
        elevation = 0.dp,
    ) {
        Row(modifier = Modifier.align(Alignment.CenterVertically)) {
            Icon(
                modifier = Modifier
                    .clickable(
                        onClickLabel = stringResource(id = R.string.cd_go_back),
                        onClick = navigateToMeterReadings
                    )
                    .semantics(mergeDescendants = true) {},
                tint = MaterialTheme.colors.onSurface,
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.cd_go_back)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = R.string.label_add_meter_reading),
                style = MaterialTheme.typography.h2,
            )
        }
    }
    Column(
        modifier = modifier
            .background(color = White)
            .padding(
                top = 100.dp,
                end = 30.dp,
                start = 30.dp,
                bottom = 30.dp,
            )
    ) {
        Spacer(modifier = Modifier.weight(1f))
        OtpTextInput(
            value = uiState.meterReading ?: "",
            maxCharsCount = METER_READING_VALUE_MIN_LENGTH,
            onValueChange = { value: String ->
                handleEvent(AddMeterReadingEvent.MeterReadingValueChanged(value))
            },
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(id = R.string.label_add_meter_reading_hint),
            fontFamily = GilroyFontSemibold,
            fontSize = 14.sp,
            lineHeight = 17.sp,
            color = Grey,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(id = R.string.cd_add_meter_reading),
            isLoading = uiState.status.isLoading(),
            enabled = uiState.isMeterReadingValid() && !uiState.status.isLoading(),
            onClick = {
                handleEvent(AddMeterReadingEvent.SaveMeterReading)
            }
        )
    }
    if (uiState.status is ActionStatus.Error) {
        ErrorDialog(
            error = uiState.status.error ?: "",
            dismissError = {
                handleEvent(AddMeterReadingEvent.ErrorDismissed)
            }
        )
    }
    if (uiState.status is ActionStatus.Success) {
        LaunchedEffect(uiState) {
            navigateToMeterReadings()
        }
    }
}