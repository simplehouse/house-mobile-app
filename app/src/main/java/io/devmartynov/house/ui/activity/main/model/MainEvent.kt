package io.devmartynov.house.ui.activity.main.model

import io.devmartynov.house.ui.shared.model.Theme

sealed class MainEvent {
    class ThemeChanged(val theme: Theme) : MainEvent()
    class AuthorizationChanged(val isAuthorized: Boolean) : MainEvent()
}