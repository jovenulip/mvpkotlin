package com.dyuben.mvpkotlin.car

import android.util.Log
import com.dyuben.mvpkotlin.api.ServiceApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CarLocationPresenter(private val mView: CarLocationContract.View) : CarLocationContract.Presenter {

    val serviceApi by lazy {
        ServiceApi.create()
    }

    init {
        mView.presenter = this
    }

    override fun getCarLocations() {
        serviceApi.locations()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    mView.showCarLocations(result.data)
                }, { error ->
                    Log.v("MainPresenter", error.message)
                })
    }

}