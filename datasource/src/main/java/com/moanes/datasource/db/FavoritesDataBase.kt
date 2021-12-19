package com.moanes.datasource.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.moanes.datasource.model.Post

@Database(
    entities = [Post::class],
    version = 1, exportSchema = false
)
@TypeConverters()
abstract class FavoritesDataBase: RoomDatabase() {
    abstract val favoriteDao:FavoriteDao
}