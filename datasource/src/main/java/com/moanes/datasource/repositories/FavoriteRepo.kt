package com.moanes.datasource.repositories

import com.moanes.datasource.db.FavoriteDao
import com.moanes.datasource.model.Post
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface FavoriteRepo {

    fun getFavorites(): Single<List<Post>>

    fun addToFavorites(item: Post) :Single<Long>

    fun removeFromFavorites(item: Post):Single<Int>

    fun getAllFavoritesIds():Single<List<String>>

    fun clearFavorites():Single<Int>
}

class FavoriteRepoImpl @Inject constructor(private val dao: FavoriteDao):FavoriteRepo{
    override fun getFavorites(): Single<List<Post>> {
        return dao.getFavorites()
    }

    override fun addToFavorites(item: Post) :Single<Long>{
      return  dao.insert(item)
    }

    override fun removeFromFavorites(item: Post):Single<Int> {
       return dao.delete(item)
    }

    override fun getAllFavoritesIds(): Single<List<String>> {
        return dao.getAllFavoritesIds()
    }

    override fun clearFavorites():Single<Int> {
       return dao.clearFavorites()
    }
}
