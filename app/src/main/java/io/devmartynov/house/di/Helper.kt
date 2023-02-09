package io.devmartynov.house.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.devmartynov.house.ui.shared.model.ThemeManager
import io.devmartynov.house.ui.shared.model.ThemeManagerImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Helper {

    @Provides
    @Singleton
    fun providesThemeManager(
        @ApplicationContext context: Context,
    ): ThemeManager {
        return ThemeManagerImpl(context)
    }
}