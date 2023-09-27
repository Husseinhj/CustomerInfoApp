package com.husseinhj.customerinfoapp.presentation.user_detail

import com.husseinhj.customerinfoapp.data.remote.dto.UserDetailDto

data class UserDetailState(
    val isLoading: Boolean = false,
    val user: UserDetailDto = UserDetailDto(),
    val error: String = ""
)
