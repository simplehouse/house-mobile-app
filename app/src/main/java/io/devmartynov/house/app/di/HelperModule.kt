package io.devmartynov.house.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.devmartynov.house.app.AppConfig
import io.devmartynov.house.app.AuthManagerImpl
import io.devmartynov.house.app.InvoicePdfServiceImpl
import io.devmartynov.house.app.model.ThemeManager
import io.devmartynov.house.app.ThemeManagerImpl
import io.devmartynov.house.app.model.AuthManager
import io.devmartynov.house.domain.model.PdfService
import io.devmartynov.house.domain.repositories.AuthStore
import io.devmartynov.house.domain.repositories.SettingsStore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HelperModule {

    @Provides
    @Singleton
    fun providesThemeManager(settingsStore: SettingsStore): ThemeManager {
        return ThemeManagerImpl(settingsStore)
    }

    @Provides
    @Singleton
    fun providesAuthManager(authStore: AuthStore): AuthManager {
        return AuthManagerImpl(authStore)
    }

    @Provides
    @Singleton
    fun provideAppConfig(): AppConfig {
        return AppConfig()
    }

    @Provides
    @Singleton
    fun providePdfService(@ApplicationContext context: Context): PdfService {
        return InvoicePdfServiceImpl(context)
    }
}