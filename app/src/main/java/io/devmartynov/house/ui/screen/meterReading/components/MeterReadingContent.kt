package io.devmartynov.house.ui.screen.meterReading.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.devmartynov.house.R
import io.devmartynov.house.app.helpers.Utils
import io.devmartynov.house.domain.model.MeterReadingEntity
import io.devmartynov.house.ui.shared.Button

@Composable
fun MeterReadingContent(
    modifier: Modifier = Modifier,
    meterReading: MeterReadingEntity,
    onShare: () -> Unit,
) {
    Column(
        modifier = modifier.padding(
            top = 35.dp,
            bottom = 30.dp,
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 30.dp),
            text = stringResource(id = R.string.label_meter_reading),
            style = MaterialTheme.typography.h2,
        )
        MeterReadingInfo(
            value = meterReading.value,
            createDate = Utils.formatDateString(meterReading.createTime),
            toPayAmount = meterReading.toPayAmount,
            diffWithPrevValue = meterReading.diffWithPrevValue,
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            label = stringResource(id = R.string.label_share_meter_reading_info),
            onClick = onShare
        )
    }
}