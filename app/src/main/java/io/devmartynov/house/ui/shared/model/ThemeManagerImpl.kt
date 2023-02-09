package io.devmartynov.house.ui.shared.model

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit

class ThemeManagerImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ThemeManager {
    private val preferences: SharedPreferences =
        context.getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
    private val _theme = MutableStateFlow(getThemeFromPreferences())
    override val theme: StateFlow<Theme> = _theme.asStateFlow()

    private fun getThemeFromPreferences(): Theme {
        val ordinal = preferences.getInt(KEY_THEME, Theme.SYSTEM.ordinal)
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
            putInt(KEY_THEME, theme.ordinal)
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

    companion object {
        private const val PREF_NAME = "theme"
        private const val KEY_THEME = "app_theme"
    }
}