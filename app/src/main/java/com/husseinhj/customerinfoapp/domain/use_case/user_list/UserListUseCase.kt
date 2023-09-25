package com.husseinhj.customerinfoapp.domain.use_case.user_list

import okio.IOException
import javax.inject.Inject
import retrofit2.HttpException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.husseinhj.customerinfoapp.common.Resource
import com.husseinhj.customerinfoapp.data.remote.dto.Customer
import com.husseinhj.customerinfoapp.data.repository.UserRepositoryImpl

class UserListUseCase @Inject constructor(
    private val repository: UserRepositoryImpl
) {

    operator fun invoke(): Flow<Resource<List<Customer>>> = flow {
        try {
            emit(Resource.Loading())
            val users = repository.getUsers().customers
            emit(Resource.Success(users))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred!", e.code()))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection!", 500))
        }
    }

}