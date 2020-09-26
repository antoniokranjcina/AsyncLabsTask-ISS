package com.async.labs.iss.fragments.location.viewpageradapterfragments.googlemaps.service.repository

import com.async.labs.iss.fragments.location.viewpageradapterfragments.googlemaps.api.RetrofitInstanceCurrentLocation
import com.async.labs.iss.fragments.location.viewpageradapterfragments.googlemaps.service.model.CurrentLocation
import retrofit2.Response

class RepositoryCurrentLocation {
    suspend fun getCurrentLocation(): Response<CurrentLocation> =
        RetrofitInstanceCurrentLocation.API_CURRENT_LOCATION.getCurrentLocation()
}