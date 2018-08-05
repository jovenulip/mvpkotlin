package com.dyuben.mvpkotlin.main

import android.util.Log
import com.dyuben.mvpkotlin.api.ServiceApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(private val mView: MainContract.View) : MainContract.Presenter {

    val serviceApi by lazy {
        ServiceApi.create()
    }

    init {
        mView.presenter = this
    }

    override fun getBookings() {
        serviceApi.availability("1533213950", "1533250800")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->

                            mView.showBookings(result.data)
                        },

                        { error ->
                            Log.v("MainPresenter", error.message)
                        }
                )
    }


}