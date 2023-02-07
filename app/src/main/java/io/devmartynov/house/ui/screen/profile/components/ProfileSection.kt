package io.devmartynov.house.ui.screen.profile.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.devmartynov.house.BuildConfig
import io.devmartynov.house.R
import io.devmartynov.house.ui.screen.profile.model.ProfileState
import io.devmartynov.house.ui.screen.profile.model.Theme
import io.devmartynov.house.ui.shared.Divider
import io.devmartynov.house.ui.theme.Red

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier,
    title: String,
    uiState: ProfileState = ProfileState(),
    onNavigateStatistic: () -> Unit = {},
    onNavigateChangePassword: () -> Unit = {},
    onChangeTheme: (theme: Theme) -> Unit = {},
    onDeleteProfile: () -> Unit = {},
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.padding(start = 30.dp),
            text = title,
            style = MaterialTheme.typography.h2,
        )
        Spacer(modifier = Modifier.height(30.dp))
        ThemeOption(
            label = stringResource(id = R.string.label_theme_option),
            selectedTheme = uiState.theme,
            onOptionSelected = onChangeTheme
        )
        Divider(
            startIndent = 30.dp,
            endIndent = 30.dp,
        )
        ProfileOption(
            label = stringResource(id = R.string.cd_change_password),
            leadingIcon = Icons.Default.Lock,
            trailingIcon = Icons.Default.KeyboardArrowRight,
            onClick = onNavigateChangePassword
        )
        Divider(
            startIndent = 30.dp,
            endIndent = 30.dp,
        )
        ProfileOption(
            label = stringResource(id = R.string.label_statistics),
            leadingIcon = Icons.Default.GraphicEq,
            trailingIcon = Icons.Default.KeyboardArrowRight,
            onClick = onNavigateStatistic
        )
        Divider(
            startIndent = 30.dp,
            endIndent = 30.dp,
        )
        ProfileOption(
            label = stringResource(id = R.string.cd_delete_profile),
            leadingIcon = Icons.Default.Person,
            iconColor = Red,
            onClick = onDeleteProfile
        )
        Divider(
            startIndent = 30.dp,
            endIndent = 30.dp,
        )
        AppVersion(
            modifier = Modifier.fillMaxSize(),
            title = stringResource(id = R.string.label_app_version),
            appVersion = BuildConfig.VERSION_NAME,
        )
    }
}
