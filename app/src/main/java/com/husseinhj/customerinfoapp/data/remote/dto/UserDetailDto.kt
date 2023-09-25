package com.husseinhj.customerinfoapp.data.remote.dto

data class UserDetailDto(
    val address: Address,
    val currentLatitude: Double,
    val currentLongitude: Double,
    val firstName: String,
    val gender: String,
    val id: Int,
    val imageUrl: String,
    val lastName: String,
    val phoneNumber: String,
    val stickers: List<String>
)