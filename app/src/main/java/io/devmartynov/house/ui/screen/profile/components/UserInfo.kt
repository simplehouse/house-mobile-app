package io.devmartynov.house.ui.screen.profile.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.devmartynov.house.ui.shared.Avatar
import io.devmartynov.house.ui.theme.DarkGrey
import io.devmartynov.house.ui.theme.GilroyFontSemibold

@Composable
fun UserInfo(
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    fullName: String,
    email: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (imageUrl != null) {
            Avatar(
                imageUrl = imageUrl,
                description = fullName,
            )
        } else {
            Avatar(
                imageVector = Icons.Default.Person,
                description = fullName,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = fullName,
            style = MaterialTheme.typography.h2,
        )
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = email,
            fontFamily = GilroyFontSemibold,
            fontSize = 16.sp,
            lineHeight = 28.sp,
            color = DarkGrey,
        )
    }
}
