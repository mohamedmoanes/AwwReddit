package com.moanes.awwreddit.ui

import com.moanes.awwreddit.base.BaseViewModel
import com.moanes.awwreddit.base.ResultListener
import com.moanes.datasource.model.Post
import com.moanes.datasource.repositories.FavoriteRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

abstract class BasePostListViewModel(private val favoriteRepo: FavoriteRepo) :
    BaseViewModel() {
    var after: String? = null
    var postsObservable = PublishSubject.create<List<Post>>()
    val postList = ArrayList<Post>()
    val favoriteIds=ArrayList<String>()

    abstract fun getPosts()

    init {
        getAllFavoritesIds()
    }

    fun addToFavorite(item: Post) {
        favoriteRepo.addToFavorites(item).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }

    fun removeFromFavorite(item: Post) {
        favoriteRepo.removeFromFavorites(item).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }
    fun handleFavorite(item: Post, remove: Boolean){
        if (remove)
            removeFromFavorite(item)
        else
            addToFavorite(item)
    }

    private fun getAllFavoritesIds(){
        singleSubscribe(favoriteRepo.getAllFavoritesIds(),object :ResultListener<List<String>>{
            override fun onSuccess(data: List<String>) {
                favoriteIds.addAll(data)
            }

            override fun onFailure(message: String) {
                //TODO("Not yet implemented")
            }
        })
    }
    fun loadNextPage() {
        if (after != null)
            getPosts()
    }
}