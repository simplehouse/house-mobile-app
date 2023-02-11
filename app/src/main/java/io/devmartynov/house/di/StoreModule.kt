package io.devmartynov.house.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.devmartynov.house.AppConfig
import io.devmartynov.house.data.local.AuthStoreImpl
import io.devmartynov.house.data.local.UserStoreImpl
import io.devmartynov.house.data.remote.*
import io.devmartynov.house.domain.repositories.AuthStore
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
}