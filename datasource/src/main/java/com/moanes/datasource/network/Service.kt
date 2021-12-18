package com.moanes.datasource.network

import com.moanes.datasource.model.PostsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("top.json")
    fun getPosts(
        @Query("t") t: String,
        @Query("limit") limit: Int,
        @Query("after") after: String?
    ): Single<PostsResponse>
}