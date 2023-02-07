package io.devmartynov.house.ui.shared

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import io.devmartynov.house.ui.theme.Blue

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    imageUrl: String,
    description: String = "",
) {
    GlideImage(
        modifier = modifier
            .size(80.dp)
            .clip(RoundedCornerShape(percent = 50))
            .border(5.dp, Blue, CircleShape),
        model = imageUrl,
        contentDescription = description,
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    description: String = "",
) {
    Icon(
        modifier = modifier
            .size(80.dp)
            .clip(RoundedCornerShape(percent = 50))
            .border(5.dp, Blue, CircleShape),
        imageVector = imageVector,
        contentDescription = description,
    )
}