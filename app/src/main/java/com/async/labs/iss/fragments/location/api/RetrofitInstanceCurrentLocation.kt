package com.async.labs.iss.fragments.location.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanceCurrentLocation {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://api.open-notify.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val API_CURRENT_LOCATION: SimpleApiCurrentLocation by lazy {
        retrofit.create(SimpleApiCurrentLocation::class.java)
    }
}