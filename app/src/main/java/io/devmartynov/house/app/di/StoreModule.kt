package io.devmartynov.house.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.devmartynov.house.app.AppConfig
import io.devmartynov.house.data.local.AuthStoreImpl
import io.devmartynov.house.data.local.SettingsStoreImpl
import io.devmartynov.house.data.local.UserStoreImpl
import io.devmartynov.house.data.remote.*
import io.devmartynov.house.domain.repositories.AuthStore
import io.devmartynov.house.domain.repositories.SettingsStore
import io.devmartynov.house.domain.repositories.UserStore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StoreModule {

    @Provides
    @Singleton
    fun provideUserStore(
        @ApplicationContext context: Context,
        appConfig: AppConfig,
    ): UserStore {
        return UserStoreImpl(context, appConfig)
    }

    @Provides
    @Singleton
    fun provideAuthStore(
        @ApplicationContext context: Context,
        appConfig: AppConfig,
    ): AuthStore {
        return AuthStoreImpl(context, appConfig)
    }

    @Provides
    @Singleton
    fun provideSettingsStore(
        @ApplicationContext context: Context,
        appConfig: AppConfig,
    ): SettingsStore {
        return SettingsStoreImpl(context, appConfig)
    }
}