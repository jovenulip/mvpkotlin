package com.dyuben.mvpkotlin.car

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dyuben.mvpkotlin.R
import com.dyuben.mvpkotlin.data.CarsModel
import kotlinx.android.synthetic.main.item_car_location.view.*

class CarLocationAdapter(val mContext: Context, val mList: List<CarsModel.DataItems>) :
        RecyclerView.Adapter<CarLocationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarLocationAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_car_location, parent, false))
    }

    override fun onBindViewHolder(holder: CarLocationAdapter.ViewHolder, position: Int) {
        holder.txtCarId?.text = mList[position].id.toString()
        holder.txtIsOnTrip?.text = mList[position].is_on_trip.toString().capitalize()
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtIsOnTrip = view.txtIsOnTrip
        val txtCarId = view.txtCarId
    }

}

