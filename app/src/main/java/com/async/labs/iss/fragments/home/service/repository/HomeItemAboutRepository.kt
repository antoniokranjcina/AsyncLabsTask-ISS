package com.async.labs.iss.fragments.home.service.repository

import com.async.labs.iss.fragments.home.api.RetrofitInstanceHomeItemAbout
import com.async.labs.iss.fragments.home.service.model.HomeItemAbout
import retrofit2.Response

class HomeItemAboutRepository {
    suspend fun getHomeItemAbout(): Response<List<HomeItemAbout>> =
        RetrofitInstanceHomeItemAbout.API_HOME_ITEM_ABOUT.getHomeItemAbout()
}