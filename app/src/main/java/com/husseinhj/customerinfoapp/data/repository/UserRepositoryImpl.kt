package com.husseinhj.customerinfoapp.data.repository

import javax.inject.Inject
import com.husseinhj.customerinfoapp.data.remote.UserApiService
import com.husseinhj.customerinfoapp.data.remote.dto.UserListDto
import com.husseinhj.customerinfoapp.data.remote.dto.UserDetailDto
import com.husseinhj.customerinfoapp.domain.repository.UserRepository

class UserRepositoryImpl @Inject constructor(
    private val api: UserApiService
) : UserRepository {

    override suspend fun getUsers(): UserListDto {
        return api.getUsers()
    }

    override suspend fun getUser(id: Int): UserDetailDto {
        return api.getUser(id)
    }

}