package com.async.labs.iss.fragments.home.api

import com.async.labs.iss.fragments.home.service.model.HomeItemAbout
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApiHomeItemAbout {
    @GET("/home-item-about")
    suspend fun getHomeItemAbout(): Response<List<HomeItemAbout>>
}