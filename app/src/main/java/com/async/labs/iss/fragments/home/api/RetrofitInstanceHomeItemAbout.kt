package com.async.labs.iss.fragments.home.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanceHomeItemAbout {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://edb074e49a29.ngrok.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val API_HOME_ITEM_ABOUT: SimpleApiHomeItemAbout by lazy {
        retrofit.create(SimpleApiHomeItemAbout::class.java)
    }
}