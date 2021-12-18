package com.moanes.datasource.repositories

import com.moanes.datasource.model.PostsResponse
import com.moanes.datasource.network.Service
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface PostsRepo {
    fun getPosts(
        limit: Int,
        after: String?
    ): Single<PostsResponse>
}

class PostRepoImpl @Inject constructor(private val remoteService: Service) : PostsRepo {
    override fun getPosts(limit: Int, after: String?): Single<PostsResponse> {
        return remoteService.getPosts("all", limit, after)
    }
}
