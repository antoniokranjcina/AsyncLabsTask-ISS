package com.async.labs.iss.fragments.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.async.labs.iss.fragments.home.service.model.HomeItemAbout
import com.async.labs.iss.fragments.home.service.repository.HomeItemAboutRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeItemAboutViewModel(private val repository: HomeItemAboutRepository) : ViewModel() {
    private val responseHomeItemAbout: MutableLiveData<Response<List<HomeItemAbout>>> =
        MutableLiveData()

    fun getResponse(): LiveData<Response<List<HomeItemAbout>>> = responseHomeItemAbout

    fun getHomeItemAbout() {
        viewModelScope.launch {
            try {
                val response = repository.getHomeItemAbout()
                responseHomeItemAbout.value = response
            } catch (e: Exception) {
                Log.d("HomeItemAboutViewModel", "Exception: " + e.message)
            }
        }
    }
}