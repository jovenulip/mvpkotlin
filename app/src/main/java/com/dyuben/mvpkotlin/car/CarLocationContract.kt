package com.dyuben.mvpkotlin.car

import com.dyuben.mvpkotlin.base.BasePresenter
import com.dyuben.mvpkotlin.base.BaseView
import com.dyuben.mvpkotlin.data.CarsModel

interface CarLocationContract {

    interface View : BaseView<Presenter> {
        fun showCarLocations(mList: List<CarsModel.DataItems>)
    }

    interface Presenter : BasePresenter {
        fun getCarLocations()
    }
}