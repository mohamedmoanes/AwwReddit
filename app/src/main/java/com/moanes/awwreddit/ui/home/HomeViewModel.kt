package com.moanes.awwreddit.ui.home

import com.moanes.awwreddit.base.ResultListener
import com.moanes.awwreddit.ui.BasePostListViewModel
import com.moanes.datasource.model.PostsResponse
import com.moanes.datasource.repositories.PostsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val postsRepo: PostsRepo) : BasePostListViewModel() {

    override fun getPosts() {
        singleSubscribe(postsRepo.getPosts(25, after), object : ResultListener<PostsResponse> {
            override fun onSuccess(data: PostsResponse) {
                after=data.data.after
                childrenList.addAll(data.data.children)
                postsObservable.onNext(childrenList)
            }

            override fun onFailure(message: String) {
            }
        })
    }
}