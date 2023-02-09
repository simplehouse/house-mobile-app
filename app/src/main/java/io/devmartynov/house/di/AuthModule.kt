package io.devmartynov.house.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.devmartynov.house.AuthImpl
import io.devmartynov.house.domain.model.Auth
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AuthModule {

    @Provides
    @Singleton
    fun providesAuth(): Auth {
        return AuthImpl()
    }
}