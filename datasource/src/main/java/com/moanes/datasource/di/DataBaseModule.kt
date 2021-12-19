package com.moanes.datasource.di

import android.content.Context
import androidx.room.Room
import com.moanes.datasource.db.FavoriteDao
import com.moanes.datasource.db.FavoritesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): FavoritesDataBase {
        return Room.databaseBuilder(
            appContext,
            FavoritesDataBase::class.java,
            "FavoritesDataBase"
        ).build()
    }
    @Provides
    fun provideChannelDao(favoritesDataBase: FavoritesDataBase): FavoriteDao {
        return favoritesDataBase.favoriteDao
    }
}