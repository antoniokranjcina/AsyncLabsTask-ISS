package com.async.labs.iss.fragments.location.viewpageradapterfragments.googlemaps.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.async.labs.iss.fragments.location.viewpageradapterfragments.googlemaps.service.model.CurrentLocation
import com.async.labs.iss.fragments.location.viewpageradapterfragments.googlemaps.service.repository.RepositoryCurrentLocation
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModelCurrentLocation(private val repository: RepositoryCurrentLocation) : ViewModel() {
    private val myResponse: MutableLiveData<Response<CurrentLocation>> = MutableLiveData()

    fun getResponse(): LiveData<Response<CurrentLocation>> = myResponse

    fun getCurrentLocation() {
        viewModelScope.launch {
            try {
                val response = repository.getCurrentLocation()
                myResponse.value = response
            } catch (e: Exception) {
                Log.d("ViewModelCurrentLocation", "getCurrentLocation: " + e.message)
            }
        }
    }
}