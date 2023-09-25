package com.husseinhj.customerinfoapp.domain.repository

import com.husseinhj.customerinfoapp.data.remote.dto.UserListDto
import com.husseinhj.customerinfoapp.data.remote.dto.UserDetailDto

interface UserRepository {

    suspend fun getUsers(): UserListDto

    suspend fun getUser(id: Int): UserDetailDto

}