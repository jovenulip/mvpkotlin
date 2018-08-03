package com.dyuben.mvpkotlin.api

import com.dyuben.mvpkotlin.Constants.Companion.BASE_URL
import com.dyuben.mvpkotlin.data.BookingModel
import com.dyuben.mvpkotlin.data.CarsModel
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface ServiceApi {
    @GET("availability")
    fun availability(@Query("startTime") startTime: String,
                     @Query("endTime") endTime: String):
            Observable<BookingModel.Data>

    @GET("locations")
    fun locations(): Observable<CarsModel.Data>

    companion object {
        fun create(): ServiceApi {

            val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            val okhttp = OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .build();

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okhttp)
                    .baseUrl(BASE_URL)
                    .build()

            return retrofit.create(ServiceApi::class.java)
        }
    }
}