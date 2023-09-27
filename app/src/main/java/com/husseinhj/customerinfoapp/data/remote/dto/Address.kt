package com.husseinhj.customerinfoapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("city") val city: String = "",
    @SerializedName("country") val country: String = "",
    @SerializedName("state") val state: String = "",
    @SerializedName("street") val street: String = "",
    @SerializedName("zip") val zip: String = ""
)