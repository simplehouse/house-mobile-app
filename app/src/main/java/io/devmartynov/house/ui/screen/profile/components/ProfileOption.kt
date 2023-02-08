package io.devmartynov.house.ui.screen.profile.components

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.devmartynov.house.ui.shared.Symbol
import io.devmartynov.house.ui.theme.Blue
import io.devmartynov.house.ui.theme.GilroyFontSemibold

@Composable
fun ProfileOption(
    modifier: Modifier = Modifier,
    label: String,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    trailingText: String? = null,
    onClickLabel: String = "",
    iconColor: Color = Blue,
    onClick: () -> Unit,
    insideContent: @Composable (() -> Unit)? = null,
    outSideContent: @Composable (() -> Unit)? = null,
) {
    Surface(modifier = modifier.heightIn(min = 85.dp)) {
        Row(
            modifier = Modifier
                .clickable(
                    onClickLabel = onClickLabel,
                    onClick = onClick
                )
                .padding(horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (leadingIcon != null) {
                Symbol(
                    imageVector = leadingIcon,
                    tint = iconColor,
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                modifier = Modifier.weight(1f),
                text = label,
                fontFamily = GilroyFontSemibold,
                fontSize = 16.sp,
                lineHeight = 20.sp,
            )
            if (trailingText != null) {
                Text(
                    text = trailingText,
                    fontFamily = GilroyFontSemibold,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                )
            }
            if (trailingIcon != null) {
                Icon(
                    imageVector = trailingIcon,
                    contentDescription = null,
                    tint = iconColor
                )
            }
            insideContent?.invoke()
        }
        outSideContent?.invoke()
    }
}
