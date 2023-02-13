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
import io.devmartynov.house.domain.model.MeterReading
import io.devmartynov.house.domain.model.Service
import io.devmartynov.house.domain.model.SubmissionDate
import io.devmartynov.house.ui.screen.main.model.MainScreenEvent
import io.devmartynov.house.ui.screen.main.model.MainScreenState
import io.devmartynov.house.ui.shared.gradientBackground
import io.devmartynov.house.ui.theme.*
import kotlin.math.max
import kotlin.math.min

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreenContent(
    modifier: Modifier = Modifier,
    uiState: MainScreenState,
    handleEvent: (event: MainScreenEvent) -> Unit,
    navigateToProfile: () -> Unit,
    navigateToAddMeterReading: (service: Int) -> Unit,
    navigateToMeterReading: (meterReading: MeterReading) -> Unit,
    getDaysUntilExpirationSubmissionDate: (service: Service) -> Int,
    isSubmissionDateExpired: (service: Service) -> Boolean,
) {
    val pageCount = Service.values().size
    val pagerState = rememberPagerState(initialPage = 0)
    val service = Service.values()[pagerState.currentPage]
    val isDateExpired = isSubmissionDateExpired(service)
    val daysUntilDateExpiration = getDaysUntilExpirationSubmissionDate(service)

    val gradientColors = if (isDateExpired || daysUntilDateExpiration < 2) {
        listOf(LightRed, Red)
    } else {
        listOf(LightBlue, Blue)
    }

    BoxWithConstraints(
        modifier = modifier
            .gradientBackground(gradientColors, angle = 125f)
    ) {
        val screenHeight = maxHeight

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
                        text = stringResource(id = Service.values()[pagerState.currentPage].label),
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
                submissionDate = when (pagerState.currentPage) {
                    0 -> uiState.gasDate
                    1 -> uiState.waterDate
                    2 -> uiState.electricityDate
                    else -> ""
                } as SubmissionDate?,
                navigateToAddMeterReading = {
                    navigateToAddMeterReading(pagerState.currentPage)
                },
                isDateExpired = isDateExpired,
                daysUntilDateExpiration = daysUntilDateExpiration,
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
                    .padding(top = 35.dp)
            ) {
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
                    MeterReadingsPage(
                        modifier = Modifier.fillMaxSize(),
                        onMeterReadingClick = navigateToMeterReading,
                        service = Service.values()[pageIndex],
                    )
                }
            }
        }
    }
}


