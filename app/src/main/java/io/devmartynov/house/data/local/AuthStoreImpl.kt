package io.devmartynov.house.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import io.devmartynov.house.AppConfig
import io.devmartynov.house.domain.repositories.AuthStore
import javax.inject.Inject

class AuthStoreImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val appConfig: AppConfig,
) : AuthStore {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(
            appConfig.SETTINGS_PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )

    override fun setAccessToken(accessToken: String?) {
        preferences.edit {
            putString(appConfig.SETTINGS_PREFERENCES_ACCESS_TOKEN_KEY, accessToken)
        }
    }

    override fun getAccessToken(): String? {
        return preferences.getString(appConfig.SETTINGS_PREFERENCES_ACCESS_TOKEN_KEY, null)
    }
}