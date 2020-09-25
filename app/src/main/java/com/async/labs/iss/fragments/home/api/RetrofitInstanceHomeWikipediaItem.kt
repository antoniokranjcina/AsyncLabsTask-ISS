package com.async.labs.iss.fragments.home.api

import com.async.labs.iss.fragments.home.api.HomeWikipediaItemApi.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanceHomeWikipediaItem {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val API_HOME_WIKIPEDIA_ITEM: HomeWikipediaItemApi by lazy {
        retrofit.create(HomeWikipediaItemApi::class.java)
    }
}