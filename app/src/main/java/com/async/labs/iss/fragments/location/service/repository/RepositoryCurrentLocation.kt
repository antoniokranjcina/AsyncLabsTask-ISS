package com.async.labs.iss.fragments.location.service.repository

import com.async.labs.iss.fragments.location.api.RetrofitInstanceCurrentLocation
import com.async.labs.iss.fragments.location.service.model.CurrentLocation
import retrofit2.Response

class RepositoryCurrentLocation {
    suspend fun getCurrentLocation(): Response<CurrentLocation> =
        RetrofitInstanceCurrentLocation.API_CURRENT_LOCATION.getCurrentLocation()
}