package io.devmartynov.house.ui.activity.main.model

import io.devmartynov.house.ui.shared.model.Theme

data class MainState(
    val isAuthorized: Boolean = true,
    val theme: Theme = Theme.SYSTEM,
)