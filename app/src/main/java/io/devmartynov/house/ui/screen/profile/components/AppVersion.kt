package io.devmartynov.house.ui.screen.profile.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun AppVersion(
    modifier: Modifier = Modifier,
    title: String,
    appVersion: String,
) {
    Surface(
        modifier = modifier
            .heightIn(min = 80.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(30.dp)
                .semantics(mergeDescendants = true) {},
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = title
            )
            Text(text = appVersion)
        }
    }
}