package com.husseinhj.customerinfoapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class UserDetailDto(
    @SerializedName("address") val address: Address = Address(),
    @SerializedName("currentLatitude") val currentLatitude: Double = 0.0,
    @SerializedName("currentLongitude") val currentLongitude: Double = 0.0,
    @SerializedName("firstName") val firstName: String = "",
    @SerializedName("gender") val gender: Gender = Gender.OTHER,
    @SerializedName("id") val id: Int = 0,
    @SerializedName("imageUrl") val imageUrl: String = "",
    @SerializedName("lastName") val lastName: String = "",
    @SerializedName("phoneNumber") val phoneNumber: String = "",
    @SerializedName("stickers") val stickers: List<Sticker> = emptyList()
)