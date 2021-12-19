package com.moanes.awwreddit.ui.favorite

import com.moanes.awwreddit.base.ResultListener
import com.moanes.awwreddit.ui.BasePostListViewModel
import com.moanes.datasource.model.Post
import com.moanes.datasource.repositories.FavoriteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val favoriteRepo: FavoriteRepo) :
    BasePostListViewModel(favoriteRepo) {
    override fun getPosts() {
        loadingObservable.onNext(true)
        singleSubscribe(favoriteRepo.getFavorites(), object : ResultListener<List<Post>> {
            override fun onSuccess(data: List<Post>) {
                postList?.addAll(data)
                postsObservable.onNext(postList)
                loadingObservable.onNext(false)
            }

            override fun onFailure(message: String) {
                loadingObservable.onNext(false)
                errorObservable.onNext(message)
            }
        })

    }

    fun clearFavorites(){
        singleSubscribe(favoriteRepo.clearFavorites(),object : ResultListener<Int>{
            override fun onSuccess(data: Int) {
                postList?.clear()
                postsObservable.onNext(postList)
            }

            override fun onFailure(message: String) {
                //TODO("Not yet implemented")
            }
        })
    }
}