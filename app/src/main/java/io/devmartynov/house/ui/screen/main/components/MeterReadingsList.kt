package io.devmartynov.house.ui.screen.main.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.devmartynov.house.R
import io.devmartynov.house.app.helpers.Utils
import io.devmartynov.house.domain.model.MeterReading
import io.devmartynov.house.domain.model.Service
import io.devmartynov.house.ui.shared.Divider
import io.devmartynov.house.ui.theme.Blue

@Composable
fun MeterReadingsList(
    modifier: Modifier = Modifier,
    meterReadings: List<MeterReading> = emptyList(),
    service: Service = Service.GAS,
    isLoading: Boolean = false,
    onMeterReadingClick: (meterReadingId: MeterReading) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier,
        userScrollEnabled = false,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (meterReadings.isEmpty() && !isLoading) {
            item {
                Text(
                    modifier = Modifier.padding(top = 80.dp),
                    text = stringResource(id = R.string.label_no_meter_readings)
                )
            }
        }
        if (isLoading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(55.dp)
                        .padding(top = 80.dp),
                    color = Blue,
                )
            }
        }
        items(meterReadings) { meterReading: MeterReading ->
            MeterReadingItem(
                date = Utils.formatDateString(meterReading.createTime),
                amount = meterReading.toPayAmount,
                isExpired = meterReading.isSubmissionDateExpired,
                onClick = {
                    onMeterReadingClick(meterReading)
                }
            )
            Divider(
                startIndent = 30.dp,
                endIndent = 30.dp,
            )
        }
    }
}