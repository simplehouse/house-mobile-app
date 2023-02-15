package io.devmartynov.house.ui.screen.profile.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import io.devmartynov.house.ui.screen.profile.model.ProfileEvent
import io.devmartynov.house.ui.screen.profile.model.ProfileState
import io.devmartynov.house.R
import io.devmartynov.house.domain.enums.Theme

@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    profileState: ProfileState = ProfileState(),
    handleEvent: (event: ProfileEvent) -> Unit = {},
    navigateToStatistics: () -> Unit = {},
    navigateToPasswordRecovery: () -> Unit = {},
    navigateToMetersReading: () -> Unit = {},
    navigateToInvoices: () -> Unit = {},
) {
    TopAppBar(
        modifier = Modifier.zIndex(1f),
        backgroundColor = MaterialTheme.colors.surface,
        contentPadding = PaddingValues(start = 15.dp),
        elevation = 0.dp,
    ) {
        Row(modifier = Modifier.align(Alignment.CenterVertically)) {
            Icon(
                modifier = Modifier.clickable(
                    onClickLabel = stringResource(id = R.string.cd_go_back),
                    onClick = navigateToMetersReading
                ),
                tint = MaterialTheme.colors.onSurface,
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.cd_go_back)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = R.string.label_profile),
                style = MaterialTheme.typography.h2,
            )
        }
    }
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(100.dp))
        UserInfo(
            modifier = Modifier.fillMaxWidth(),
            fullName = profileState.fullName ?: "",
            email = profileState.email ?: "",
            imageUrl = profileState.imageUrl
        )
        Spacer(modifier = Modifier.height(70.dp))
        ProfileSection(
            title = stringResource(id = R.string.label_settings),
            uiState = profileState,
            onNavigateStatistic = navigateToStatistics,
            onNavigateChangePassword = navigateToPasswordRecovery,
            onNavigateInvoices = navigateToInvoices,
            onChangeTheme = { theme: Theme ->
                handleEvent(ProfileEvent.ThemeChanged(theme))
            },
            onDeleteProfile = {
                handleEvent(ProfileEvent.ProfileDeleted)
            },
            onSignOut = {
                handleEvent(ProfileEvent.SignOut)
            }
        )
    }
}