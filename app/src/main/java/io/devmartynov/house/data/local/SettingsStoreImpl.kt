package io.devmartynov.house.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import io.devmartynov.house.app.AppConfig
import io.devmartynov.house.domain.enums.Theme
import io.devmartynov.house.domain.repositories.SettingsStore
import javax.inject.Inject

class SettingsStoreImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val appConfig: AppConfig,
) : SettingsStore {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(
            appConfig.SETTINGS_PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )

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
    }

    override fun getTheme(): Theme {
        val ordinal = preferences.getInt(
            appConfig.SETTINGS_PREFERENCES_THEME_KEY,
            Theme.SYSTEM.ordinal
        )
        return Theme.values()[ordinal]
    }
}