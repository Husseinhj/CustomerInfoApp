@file:Suppress("unused")

package com.husseinhj.customerinfoapp.data.remote.dto

import com.google.gson.annotations.SerializedName

enum class Gender(val value: String) {
    @SerializedName("female", alternate = ["FEMALE"])
    FEMALE("Female"),
    @SerializedName("male", alternate = ["MALE"])
    MALE("Male"),
    @SerializedName("other", alternate = ["OTHER"])
    OTHER("Other")
}
