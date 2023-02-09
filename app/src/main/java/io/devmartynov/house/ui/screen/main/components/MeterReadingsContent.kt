package io.devmartynov.house.ui.screen.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.google.accompanist.pager.*
import io.devmartynov.house.R
import io.devmartynov.house.ui.screen.main.model.MeterReadingsEvent
import io.devmartynov.house.ui.screen.main.model.MeterReadingsState
import io.devmartynov.house.ui.screen.main.model.Services
import io.devmartynov.house.ui.shared.gradientBackground
import io.devmartynov.house.ui.theme.*
import kotlin.math.max
import kotlin.math.min

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MeterReadingsContent(
    modifier: Modifier = Modifier,
    meterReadingsState: MeterReadingsState = MeterReadingsState(),
    handleEvent: (event: MeterReadingsEvent) -> Unit = {},
    navigateToProfile: () -> Unit = {},
    navigateToAddMeterReading: (service: Int) -> Unit = {},
    navigateToMeterReading: (meterReadingId: Int) -> Unit = {},
) {
    BoxWithConstraints(
        modifier = modifier
            .gradientBackground(listOf(LightBlue, Blue), angle = 125f)
    ) {
        val screenHeight = maxHeight
        val pageCount = Services.values().size
        val pagerState = rememberPagerState(initialPage = 0)

        TopAppBar(
            modifier = Modifier.zIndex(1f),
            backgroundColor = Color.Transparent,
            contentPadding = PaddingValues(start = 30.dp, end = 30.dp),
            elevation = 0.dp,
        ) {
            Row(modifier = Modifier.align(Alignment.CenterVertically)) {
                Icon(
                    tint = Color.Transparent,
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                )
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = Services.values()[pagerState.currentPage].label),
                        color = White,
                        textAlign = TextAlign.Center,
                        fontFamily = GilroyFontMedium,
                        fontSize = 18.sp,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        pageCount = pageCount,
                        inactiveColor = White.copy(0.6f),
                        activeColor = White,
                        indicatorHeight = 5.dp,
                        indicatorWidth = 5.dp,
                    )
                }
                Icon(
                    modifier = Modifier.clickable(
                        onClickLabel = stringResource(id = R.string.cd_go_to_profile),
                        onClick = {
                            navigateToProfile()
                        }
                    ),
                    tint = White,
                    imageVector = Icons.Default.Person,
                    contentDescription = stringResource(id = R.string.cd_go_to_profile)
                )
            }
        }
        val scrollState = rememberScrollState()
        val cornerSize = max(-(scrollState.value * 0.05f - 50), 0f)
        val absoluteOffset = (scrollState.value * 0.2f)
        val alpha = min(1f, 1 - (scrollState.value / 700f))
        Column(
            modifier = modifier
                .verticalScroll(state = scrollState),
        ) {
            Spacer(modifier = Modifier.height(140.dp))
            ServiceStatus(
                modifier = Modifier
                    .fillMaxWidth()
                    .absoluteOffset(y = absoluteOffset.dp)
                    .alpha(alpha),
                meterReadingEnteringDate = if (pagerState.currentPage == 1) "10.01.2023" else "23.03.2023",
                navigateToAddMeterReading = {
                    navigateToAddMeterReading(pagerState.currentPage)
                }
            )
            Spacer(modifier = Modifier.height(80.dp))
            Column(
                modifier = Modifier
                    .height(screenHeight)
                    .background(
                        color = White,
                        shape = Shapes.small.copy(
                            topStart = CornerSize(cornerSize.dp),
                            topEnd = CornerSize(cornerSize.dp),
                            bottomStart = CornerSize(0.dp),
                            bottomEnd = CornerSize(0.dp),
                        )
                    )
            ) {
                Spacer(modifier = Modifier.height(35.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 30.dp),
                    text = stringResource(id = R.string.label_last_meter_readings),
                    style = MaterialTheme.typography.h2,
                )
                Spacer(modifier = Modifier.height(30.dp))
                HorizontalPager(
                    count = pageCount,
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxHeight(),
                ) { pageIndex ->
                    MeterReadingsList(
                        modifier = Modifier.fillMaxSize(),
                        meterReadings = meterReadingsState.get(pageIndex).meterReadings,
                        onMeterReadingClick = navigateToMeterReading,
                    )
                }
            }
        }
    }
}


