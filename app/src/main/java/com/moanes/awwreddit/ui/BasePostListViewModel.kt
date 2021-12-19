package com.moanes.awwreddit.ui

import com.moanes.awwreddit.base.BaseViewModel
import com.moanes.awwreddit.base.ResultListener
import com.moanes.datasource.model.Post
import com.moanes.datasource.repositories.FavoriteRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

abstract class BasePostListViewModel(private val favoriteRepo: FavoriteRepo) :
    BaseViewModel() {
    var after: String? = null

    var postsObservable: PublishSubject<List<Post>> = PublishSubject.create()
    var loadingObservable: PublishSubject<Boolean> = PublishSubject.create()
    var errorObservable: PublishSubject<String> = PublishSubject.create()

    var postList: MutableList<Post>? = ArrayList<Post>()
    var favoriteIds: MutableList<String>? = ArrayList<String>()

    abstract fun getPosts()

    init {
        getAllFavoritesIds()
    }

    private fun addToFavorite(item: Post) {
        favoriteRepo.addToFavorites(item).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }

    private fun removeFromFavorite(item: Post) {
        favoriteRepo.removeFromFavorites(item).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }

    fun handleFavorite(item: Post, remove: Boolean) {
        if (remove)
            removeFromFavorite(item)
        else
            addToFavorite(item)
    }

    private fun getAllFavoritesIds(){
        singleSubscribe(favoriteRepo.getAllFavoritesIds(),object :ResultListener<List<String>>{
            override fun onSuccess(data: List<String>) {
                favoriteIds?.addAll(data)
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

    override fun onCleared() {
        super.onCleared()
        postsObservable.onComplete()
        loadingObservable.onComplete()
        errorObservable.onComplete()

        postList = null
        favoriteIds = null
    }
}