package com.husseinhj.customerinfoapp.data.remote.dto

data class UserDetailDto(
    val address: Address = Address(),
    val currentLatitude: Double = 0.0,
    val currentLongitude: Double = 0.0,
    val firstName: String = "",
    val gender: Gender = Gender.OTHER,
    val id: Int = 0,
    val imageUrl: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val stickers: List<Sticker> = emptyList()
)