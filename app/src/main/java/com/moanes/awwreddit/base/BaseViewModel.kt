package com.moanes.awwreddit.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


abstract class BaseViewModel:ViewModel() {
     var disposables = CompositeDisposable()

    protected fun <T> singleSubscribe(single: Single<T>, result: ResultListener<T>): Disposable {
        val disposable = single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response: T ->  result.onSuccess(response) }
                ) { throwable: Throwable -> throwable.localizedMessage }
        disposables.add(disposable)
        return disposable
    }


    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}