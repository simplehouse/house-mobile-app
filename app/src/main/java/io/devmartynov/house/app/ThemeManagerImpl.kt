package io.devmartynov.house.app

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit
import io.devmartynov.house.app.enums.Theme
import io.devmartynov.house.app.model.ThemeManager

class ThemeManagerImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val appConfig: AppConfig,
) : ThemeManager {
    private val preferences: SharedPreferences =
        context.getSharedPreferences(
            appConfig.SETTINGS_PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
    private val _theme = MutableStateFlow(getThemeFromPreferences())
    override val theme: StateFlow<Theme> = _theme.asStateFlow()

    private fun getThemeFromPreferences(): Theme {
        val ordinal = preferences.getInt(
            appConfig.SETTINGS_PREFERENCES_THEME_KEY,
            Theme.SYSTEM.ordinal
        )
        return Theme.values()[ordinal]
    }

    override fun setTheme(theme: Theme) {
        AppCompatDelegate.setDefaultNightMode(
            when (theme) {
                Theme.SYSTEM -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                Theme.LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
                Theme.DARK -> AppCompatDelegate.MODE_NIGHT_YES
            }
        )
        preferences.edit {
            putInt(appConfig.SETTINGS_PREFERENCES_THEME_KEY, theme.ordinal)
        }
        _theme.value = theme
    }

    override fun isDark(theme: Theme): Boolean? {
        return when (theme) {
            Theme.DARK -> true
            Theme.LIGHT -> false
            Theme.SYSTEM -> null
        }
    }
}