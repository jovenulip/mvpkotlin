package com.dyuben.mvpkotlin.main

import com.dyuben.mvpkotlin.base.BasePresenter
import com.dyuben.mvpkotlin.base.BaseView
import com.dyuben.mvpkotlin.data.BookingModel

interface MainContract {
    interface View : BaseView<Presenter> {
        fun showBookings(mList: List<BookingModel.DataItems>)
    }

    interface Presenter : BasePresenter {
        fun getBookings()
    }
}