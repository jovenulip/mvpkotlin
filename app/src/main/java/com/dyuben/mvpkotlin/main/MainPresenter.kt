package com.dyuben.mvpkotlin.main

import android.util.Log
import com.dyuben.mvpkotlin.api.ServiceApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(private val mainView: MainContract.View) : MainContract.Presenter {


    val serviceApi by lazy {
        ServiceApi.create()
    }


    init {
        mainView.presenter = this
    }

    override fun getLocation() {
        serviceApi.locations()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    for (i in result.data) {
                        Log.v("MainPresenter", "has result ${i.is_on_trip}")
                    }
                }, { error ->
                    Log.v("MainPresenter", error.message)
                })
    }

    override fun getAvailability() {
        serviceApi.availability("1533213950", "1533250800")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->

                            var i = 0
                            var s = ""

                            while (i <= 10) {
                                val cars = result.data[i].available_cars
                                s += "$cars > "
                                i++
                            }
                            mainView.updateText(s)
                        },

                        { error ->
                            Log.v("MainPresenter", error.message)
                        }
                )
    }

    override fun changeText(s: String) {
        mainView.updateText(s.toUpperCase())
    }
}