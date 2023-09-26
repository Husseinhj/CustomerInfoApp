package com.husseinhj.customerinfoapp.data.remote.dto

data class Customer(
    val firstName: String,
    val gender: Gender,
    val id: Int,
    val imageUrl: String,
    val lastName: String,
    val phoneNumber: String,
    var stickers: List<Sticker>
)