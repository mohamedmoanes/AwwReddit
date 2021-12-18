package com.moanes.awwreddit.base

interface ResultListener<T> {
    fun onSuccess(data: T)
    fun onFailure(message: String)
}