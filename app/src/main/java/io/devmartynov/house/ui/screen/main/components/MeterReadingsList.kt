package io.devmartynov.house.ui.screen.main.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.devmartynov.house.R
import io.devmartynov.house.ui.screen.main.model.MeterReading
import io.devmartynov.house.ui.shared.Divider

@Composable
fun MeterReadingsList(
    modifier: Modifier = Modifier,
    meterReadings: List<MeterReading> = emptyList(),
    onMeterReadingClick: (meterReadingId: Int) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier,
        userScrollEnabled = false,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (meterReadings.isEmpty()) {
            item {
                Text(
                    modifier = Modifier.padding(top = 80.dp),
                    text = stringResource(id = R.string.label_no_meter_readings)
                )
            }
        }
        items(meterReadings) { meterReading: MeterReading ->
            MeterReadingItem(
                date = meterReading.createDate,
                amount = meterReading.amount,
                isExpired = meterReading.isExpired,
                onClick = {
                    onMeterReadingClick(meterReading.id)
                }
            )
            Divider(
                startIndent = 30.dp,
                endIndent = 30.dp,
            )
        }
    }
}