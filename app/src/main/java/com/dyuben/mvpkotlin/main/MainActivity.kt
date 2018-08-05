package com.dyuben.mvpkotlin.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.dyuben.mvpkotlin.R
import com.dyuben.mvpkotlin.car.CarLocationActivity
import com.dyuben.mvpkotlin.data.BookingModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    override lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        btnBooking.setOnClickListener {
            presenter.getBookings()
        }

        btnCar.setOnClickListener {
            startActivity(Intent(this, CarLocationActivity::class.java))
        }
    }

    override fun showBookings(mList: List<BookingModel.DataItems>) {
        rvBookingList.layoutManager = LinearLayoutManager(this)
        rvBookingList.adapter = BookingAdapter(this, mList)
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


