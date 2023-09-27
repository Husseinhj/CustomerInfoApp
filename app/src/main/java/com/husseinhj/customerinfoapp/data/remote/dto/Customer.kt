package com.husseinhj.customerinfoapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Customer(
    @SerializedName("firstName") val firstName: String,
    @SerializedName("gender") val gender: Gender,
    @SerializedName("id") val id: Int,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("stickers") var stickers: List<Sticker>
)