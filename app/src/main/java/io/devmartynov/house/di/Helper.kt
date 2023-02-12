package io.devmartynov.house.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.devmartynov.house.app.AppConfig
import io.devmartynov.house.app.model.ThemeManager
import io.devmartynov.house.app.ThemeManagerImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Helper {

    @Provides
    @Singleton
    fun providesThemeManager(
        @ApplicationContext context: Context,
        appConfig: AppConfig,
    ): ThemeManager {
        return ThemeManagerImpl(context, appConfig)
    }

    @Provides
    @Singleton
    fun provideAppConfig(): AppConfig {
        return AppConfig()
    }
}