package com.husseinhj.customerinfoapp.presentation.user_list

import com.husseinhj.customerinfoapp.data.remote.dto.Customer

data class UserListState(
    val isLoading: Boolean = false,
    val users: List<Customer> = emptyList(),
    val error: String = ""
)
