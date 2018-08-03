package com.dyuben.mvpkotlin.data

object CarsModel {
    data class Data(val data: List<DataItems>)
    data class DataItems(val id: Int, val latitude: Double, val longitude: Double, val is_on_trip: Boolean)
}