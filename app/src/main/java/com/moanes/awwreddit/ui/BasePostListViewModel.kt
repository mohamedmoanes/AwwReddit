package com.moanes.awwreddit.ui

import com.moanes.awwreddit.base.BaseViewModel
import com.moanes.datasource.model.Children
import com.moanes.datasource.repositories.PostsRepo
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

abstract class BasePostListViewModel() :
    BaseViewModel() {
    var after: String? = null
    var postsObservable = PublishSubject.create<List<Children>>()
     val childrenList = ArrayList<Children>()

    abstract fun getPosts()

    fun loadNextPage() {
        if (after != null)
            getPosts()
    }
}