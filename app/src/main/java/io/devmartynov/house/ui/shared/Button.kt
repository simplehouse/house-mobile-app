package io.devmartynov.house.ui.shared

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.devmartynov.house.ui.theme.*

@Composable
fun Button(
    modifier: Modifier = Modifier,
    label: String = "",
    isLoading: Boolean = false,
    enabled: Boolean = true,
    elevation: ButtonElevation? = null,
    labelFontSize: TextUnit = 18.sp,
    imageVector: ImageVector? = null,
    onClick: () -> Unit = {},
) {
    val noRippleInteractionSource = remember { NoRippleInteractionSource() }
    val mutableInteractionSource = remember { MutableInteractionSource() }

    Button(
        modifier = modifier
            .heightIn(52.dp)
            .widthIn(52.dp)
            .animateContentSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Blue,
            disabledBackgroundColor = LightBlue
        ),
        onClick = onClick,
        elevation = elevation,
        contentPadding = PaddingValues(15.dp),
        enabled = enabled && !isLoading,
        interactionSource = if (isLoading) noRippleInteractionSource else mutableInteractionSource,
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(22.dp, 22.dp),
                color = White,
                strokeWidth = 4.dp,
            )
        } else if (imageVector != null) {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                tint = White,
            )
        } else {
            Text(
                text = label,
                fontSize = labelFontSize,
                fontFamily = GilroyFontSemibold,
                color = White,
            )
        }
    }
}