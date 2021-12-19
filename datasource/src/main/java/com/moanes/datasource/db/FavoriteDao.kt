package com.moanes.datasource.db

import androidx.room.*
import com.moanes.datasource.model.Post
import io.reactivex.rxjava3.core.Single

@Dao
interface FavoriteDao {
    @Query("Select * from Favorite")
    fun getFavorites(): Single<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(item: Post):Single<Long>

     @Delete
     fun delete(item: Post):Single<Int>

    @Query("DELETE FROM Favorite")
     fun clearFavorites():Single<Int>

    @Query("Select id FROM Favorite")
     fun getAllFavoritesIds():Single<List<String>>
}