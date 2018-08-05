package com.dyuben.mvpkotlin.car

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.dyuben.mvpkotlin.R
import com.dyuben.mvpkotlin.data.CarsModel
import kotlinx.android.synthetic.main.activity_car_location.*

class CarLocationActivity : AppCompatActivity(), CarLocationContract.View {

    override lateinit var presenter: CarLocationContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_location)

        presenter = CarLocationPresenter(this)
        presenter.getCarLocations()
    }

    override fun showCarLocations(mList: List<CarsModel.DataItems>) {
        rvCarList.layoutManager = LinearLayoutManager(this)
        rvCarList.adapter = CarLocationAdapter(this, mList)
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
