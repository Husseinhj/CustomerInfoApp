package com.husseinhj.customerinfoapp.presentation.user_list.component.viewholder

import com.husseinhj.customerinfoapp.data.remote.dto.Customer

interface UserListItemOnClickListener {
    fun onClickListener(customer: Customer)
}