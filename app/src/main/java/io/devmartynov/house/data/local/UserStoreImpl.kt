package io.devmartynov.house.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import io.devmartynov.house.AppConfig
import io.devmartynov.house.domain.model.User
import io.devmartynov.house.domain.repositories.UserStore
import javax.inject.Inject

class UserStoreImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val appConfig: AppConfig,
) : UserStore {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(
            appConfig.SETTINGS_PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )

    override fun setUser(user: User) {
        preferences.edit {
            putString(
                appConfig.SETTINGS_PREFERENCES_USER_ID_KEY,
                user.id.toString()
            )
            putString(
                appConfig.SETTINGS_PREFERENCES_USER_EMAIL_KEY,
                user.email
            )
            putString(
                appConfig.SETTINGS_PREFERENCES_USER_NAME_KEY,
                user.name
            )
            putString(
                appConfig.SETTINGS_PREFERENCES_USER_AVATAR_URL_KEY,
                user.avatarUrl
            )
        }
    }

    override fun getUser(): User? {
        val id = preferences.getString(appConfig.SETTINGS_PREFERENCES_USER_ID_KEY, null) ?: return null

        val email = preferences.getString(appConfig.SETTINGS_PREFERENCES_USER_EMAIL_KEY, null)
        val name = preferences.getString(appConfig.SETTINGS_PREFERENCES_USER_NAME_KEY, null)
        val avatarUrl = preferences.getString(appConfig.SETTINGS_PREFERENCES_USER_AVATAR_URL_KEY, null)

        return User(
            id = id.toInt(),
            email = email ?: "",
            name = name ?: "",
            avatarUrl = avatarUrl,
            isBanned = false
        )
    }
}