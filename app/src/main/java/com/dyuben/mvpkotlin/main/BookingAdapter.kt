package com.dyuben.mvpkotlin.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dyuben.mvpkotlin.R
import com.dyuben.mvpkotlin.data.BookingModel
import kotlinx.android.synthetic.main.item_booking.view.*

class BookingAdapter(val mContext: Context, val mList: List<BookingModel.DataItems>) :
        RecyclerView.Adapter<BookingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_booking, parent, false))
    }

    override fun onBindViewHolder(holder: BookingAdapter.ViewHolder, position: Int) {
        holder.txtCarId?.text = mList[position].id.toString()
        holder.txtAvailableCars?.text = mList[position].available_cars.toString()
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtCarId = view.txtCarId
        val txtAvailableCars = view.txtAvailableCars
    }

}