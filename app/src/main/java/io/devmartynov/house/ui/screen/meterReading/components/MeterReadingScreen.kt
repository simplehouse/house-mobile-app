package io.devmartynov.house.ui.screen.meterReading.components

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat
import androidx.navigation.NavBackStackEntry
import io.devmartynov.house.R
import io.devmartynov.house.app.helpers.Utils
import io.devmartynov.house.ui.navigation.model.Route

@Composable
fun MeterReadingScreen(
    previousBackStack: NavBackStackEntry?,
) {
    val meterReading = Route.MeterReading.getMeterReading(previousBackStack)
        ?: throw java.lang.IllegalArgumentException(
            "No meter reading found in previous back stack entry in MeterReadingScreen"
        )

    val context = LocalContext.current
    val shareTitle = stringResource(id = R.string.label_share_meter_reading_info)
    val shareSubject = stringResource(
        id = R.string.label_share_subject,
        Utils.formatDateString(meterReading.createTime)
    )
    val shareText = stringResource(
        id = R.string.label_share_text,
        stringResource(id = meterReading.service.label),
        Utils.formatDateString(meterReading.createTime),
        meterReading.value.toString(),
        meterReading.diffWithPrevValue.toString(),
        meterReading.toPayAmount,
        stringResource(id = R.string.app_name),
    )

    MeterReadingContent(
        meterReading = meterReading,
        onShare = {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
            intent.putExtra(Intent.EXTRA_TEXT, shareText)

            ContextCompat.startActivity(
                context,
                Intent.createChooser(intent, shareTitle),
                null
            )
        }
    )
}