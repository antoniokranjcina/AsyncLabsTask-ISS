package com.async.labs.iss.fragments.location.viewpageradapterfragments.googlemaps.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.async.labs.iss.fragments.location.viewpageradapterfragments.googlemaps.service.repository.RepositoryCurrentLocation

class ViewModelFactoryCurrentLocation(private val repository: RepositoryCurrentLocation) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelCurrentLocation(repository) as T
    }
}