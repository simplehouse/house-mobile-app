package io.devmartynov.house.ui.screen.profile.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Colorize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.devmartynov.house.ui.screen.profile.model.Theme
import io.devmartynov.house.ui.theme.Black
import io.devmartynov.house.ui.theme.GilroyFontMedium

@Composable
fun ThemeOption(
    modifier: Modifier = Modifier,
    label: String,
    selectedTheme: Theme,
    onOptionSelected: (option: Theme) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    ProfileOption(
        modifier = modifier,
        label = label,
        leadingIcon = Icons.Default.Colorize,
        trailingText = stringResource(id = selectedTheme.label),
        onClick = { expanded = !expanded }
    ) {
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(16.dp, 0.dp),
        ) {
            Theme.values().forEach { theme ->
                DropdownMenuItem(
                    onClick = {
                        onOptionSelected(theme)
                        expanded = false
                    },
                ) {
                    Text(
                        text = stringResource(id = theme.label),
                        fontSize = 18.sp,
                        fontFamily = GilroyFontMedium,
                        lineHeight = 25.sp,
                        color = Black,
                    )
                }
            }
        }
    }
}
