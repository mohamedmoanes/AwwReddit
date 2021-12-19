package com.moanes.awwreddit.ui.search

import com.moanes.awwreddit.base.ResultListener
import com.moanes.awwreddit.ui.BasePostListViewModel
import com.moanes.datasource.model.PostsResponse
import com.moanes.datasource.repositories.FavoriteRepo
import com.moanes.datasource.repositories.PostsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val postsRepo: PostsRepo,
    favoriteRepo: FavoriteRepo
) : BasePostListViewModel(favoriteRepo) {
    var query: String? = null
        set(value) {
            field = value
            after=null
            postList.clear()
            postsObservable.onNext(postList)
        }

    override fun getPosts() {
        if(!query.isNullOrBlank())
        singleSubscribe(
            postsRepo.searchPosts(query, 25, after),
            object : ResultListener<PostsResponse> {
                override fun onSuccess(data: PostsResponse) {
                    after = data.data.after
                    for (item in data.data.children) {
                        postList.add(item.post)
                    }
                    postsObservable.onNext(postList)
                }

                override fun onFailure(message: String) {
                }
            })
    }
}