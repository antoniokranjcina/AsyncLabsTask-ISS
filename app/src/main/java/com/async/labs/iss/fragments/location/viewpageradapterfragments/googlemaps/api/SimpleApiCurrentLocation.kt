package com.async.labs.iss.fragments.location.viewpageradapterfragments.googlemaps.api

import com.async.labs.iss.fragments.location.viewpageradapterfragments.googlemaps.service.model.CurrentLocation
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApiCurrentLocation {
    @GET("/iss-now.json")
    suspend fun getCurrentLocation(): Response<CurrentLocation>
}