package io.devmartynov.house.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.devmartynov.house.BuildConfig
import io.devmartynov.house.data.remote.*
import io.devmartynov.house.data.remote.intercepter.ErrorInterceptor
import io.devmartynov.house.data.remote.intercepter.HeaderInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideMeterReadingApi(retrofit: Retrofit): MeterReadingApi {
        return retrofit.create(MeterReadingApi::class.java)
    }

    @Provides
    @Singleton
    fun provideInvoiceApi(retrofit: Retrofit): InvoiceApi {
        return retrofit.create(InvoiceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    @Provides
    fun provideOkHttpClient(
        headerInterceptor: HeaderInterceptor,
        errorInterceptor: ErrorInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(errorInterceptor)
            .addInterceptor(headerInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.APP_BACKEND_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}