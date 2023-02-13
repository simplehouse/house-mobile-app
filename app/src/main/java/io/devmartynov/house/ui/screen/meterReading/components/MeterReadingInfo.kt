package io.devmartynov.house.ui.screen.meterReading.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.devmartynov.house.R
import io.devmartynov.house.ui.shared.Divider

@Composable
fun MeterReadingInfo(
    modifier: Modifier = Modifier,
    value: Float,
    createDate: String,
    toPayAmount: Float,
    diffWithPrevValue: Float,
) {
    Column(
        modifier = modifier.padding(
            top = 35.dp,
            bottom = 30.dp,
            start = 30.dp,
            end = 30.dp,
        ),
    ) {
        Data(
            title = stringResource(id = R.string.label_meter_reading_value),
            value = stringResource(id = R.string.label_measure, value.toString()),
        )
        Divider()
        DiffData(
            title = stringResource(id = R.string.label_diff_with_prev_value),
            isPositive = diffWithPrevValue == 0f,
            diff = stringResource(id = R.string.label_measure, diffWithPrevValue.toString()),
        )
        Divider()
        Data(
            title = stringResource(id = R.string.label_create_date),
            value = stringResource(id = R.string.label_meter_reading_create_date, createDate),
        )
        Divider()
        Data(
            title = stringResource(id = R.string.label_create_date),
            value = stringResource(
                id = R.string.label_amount_with_currency,
                toPayAmount.toString()
            ),
        )
    }
}