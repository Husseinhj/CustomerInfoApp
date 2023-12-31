package com.husseinhj.customerinfoapp.domain.use_case.user_detail

import javax.inject.Inject
import java.io.IOException
import retrofit2.HttpException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.husseinhj.customerinfoapp.common.Resource
import com.husseinhj.customerinfoapp.data.remote.dto.UserDetailDto
import com.husseinhj.customerinfoapp.domain.repository.UserRepository

class UserDetailUseCase @Inject constructor(
    private val repository: UserRepository
) {

    operator fun invoke(userId: Int): Flow<Resource<UserDetailDto>> = flow {
        try {
            emit(Resource.Loading())
            val user = repository.getUser(userId)
            emit(Resource.Success(user))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred!", e.code()))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection!", 500))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error happen!", 501))
        }
    }

}