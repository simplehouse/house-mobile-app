package io.devmartynov.house.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.devmartynov.house.data.remote.AuthApi
import io.devmartynov.house.data.remote.MeterReadingApi
import io.devmartynov.house.data.remote.repository.AuthRepositoryImpl
import io.devmartynov.house.data.remote.repository.MeterReadingsRepositoryImpl
import io.devmartynov.house.domain.repositories.AuthRepository
import io.devmartynov.house.domain.repositories.MeterReadingsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMeterReadingsRepository(meterReadingApi: MeterReadingApi): MeterReadingsRepository {
        return MeterReadingsRepositoryImpl(meterReadingApi)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(authApi: AuthApi): AuthRepository {
        return AuthRepositoryImpl(authApi)
    }
}