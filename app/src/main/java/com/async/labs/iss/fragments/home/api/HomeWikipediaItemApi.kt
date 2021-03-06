package com.async.labs.iss.fragments.home.api

import com.async.labs.iss.fragments.home.service.model.HomeWikipediaItems
import retrofit2.Response
import retrofit2.http.GET

interface HomeWikipediaItemApi {

    companion object {
//        const val BASE_URL = "http://localhost:3000"
const val BASE_URL = "http://bf6cddfe2b40.ngrok.io"
    }

    @GET("/home-about-info")
    suspend fun getHomeWikipediaItems(): Response<List<HomeWikipediaItems>>
}