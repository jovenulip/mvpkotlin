package com.dyuben.mvpkotlin.data

object BookingModel {
    data class Data(val data: List<DataItems>)
    data class DataItems(val id: Int, val location: List<Double>, val available_cars: Int, val dropoff_locations: List<DropOffLocations>)
    data class DropOffLocations(val id: Int, val location: List<Double>)
}