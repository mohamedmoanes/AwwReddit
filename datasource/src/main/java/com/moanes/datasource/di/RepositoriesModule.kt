package com.moanes.datasource.di

import com.moanes.datasource.db.FavoriteDao
import com.moanes.datasource.network.Service
import com.moanes.datasource.repositories.FavoriteRepo
import com.moanes.datasource.repositories.FavoriteRepoImpl
import com.moanes.datasource.repositories.PostRepoImpl
import com.moanes.datasource.repositories.PostsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Provides
    fun providePostsRepo(service: Service): PostsRepo {
        return PostRepoImpl(service)
    }

    @Provides
    fun provideFavoriteRepo(dao: FavoriteDao): FavoriteRepo {
        return FavoriteRepoImpl(dao)
    }
}