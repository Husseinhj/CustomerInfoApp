package com.husseinhj.customerinfoapp.domain.use_case.user_list

import javax.inject.Inject
import java.io.IOException
import retrofit2.HttpException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.husseinhj.customerinfoapp.common.Resource
import com.husseinhj.customerinfoapp.data.remote.dto.Customer
import com.husseinhj.customerinfoapp.domain.repository.UserRepository

class UserListUseCase @Inject constructor(
    private val repository: UserRepository
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
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error happen!", 501))
        }
    }

}