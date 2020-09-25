package com.async.labs.iss.fragments.home.service.repository

import com.async.labs.iss.fragments.home.api.RetrofitInstanceHomeWikipediaItem
import com.async.labs.iss.fragments.home.service.model.HomeWikipediaItems
import retrofit2.Response

class HomeWikipediaItemsRepository {
    suspend fun getHomeItemAbout(): Response<List<HomeWikipediaItems>> =
        RetrofitInstanceHomeWikipediaItem.API_HOME_WIKIPEDIA_ITEM.getHomeWikipediaItems()
}