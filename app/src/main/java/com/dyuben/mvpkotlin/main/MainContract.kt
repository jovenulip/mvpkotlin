package com.dyuben.mvpkotlin.main

import com.dyuben.mvpkotlin.base.BasePresenter
import com.dyuben.mvpkotlin.base.BaseView

interface MainContract {
    interface View : BaseView<Presenter>{
        fun updateText(s : String)
    }
    interface Presenter : BasePresenter {
        fun changeText(s: String)
        fun getAvailability()
        fun getLocation()
    }
}