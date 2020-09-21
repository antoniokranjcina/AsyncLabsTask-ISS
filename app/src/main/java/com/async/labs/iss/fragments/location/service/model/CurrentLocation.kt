package com.async.labs.iss.fragments.location.service.model

import com.google.gson.annotations.SerializedName

data class CurrentLocation(
    val message: String,
    @SerializedName("iss_position")
    val issPosition: IssPosition,
    val timestamp: Double
)