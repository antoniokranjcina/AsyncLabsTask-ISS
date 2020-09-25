package com.async.labs.iss.fragments.home.viewmodel

import android.util.Log
//import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.async.labs.iss.fragments.home.service.model.HomeWikipediaItems
import com.async.labs.iss.fragments.home.service.repository.HomeWikipediaItemsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeWikipediaItemsViewModel(
    private val repository: HomeWikipediaItemsRepository
) : ViewModel() {

    private val responseHomeWikipediaItems: MutableLiveData<Response<List<HomeWikipediaItems>>> =
        MutableLiveData()

    fun getResponse(): LiveData<Response<List<HomeWikipediaItems>>> = responseHomeWikipediaItems

    fun getHomeWikipediaItems() {
        viewModelScope.launch {
            try {
                val response = repository.getHomeItemAbout()
                responseHomeWikipediaItems.value = response
            } catch (e: Exception) {
                Log.d("HomeItemAboutViewModel", "Exception: " + e.message)
            }
        }
    }
}