package com.husseinhj.customerinfoapp.domain.use_case.user_detail

import com.husseinhj.customerinfoapp.common.Resource
import com.husseinhj.customerinfoapp.data.remote.dto.Gender
import com.husseinhj.customerinfoapp.data.remote.dto.Sticker
import com.husseinhj.customerinfoapp.data.remote.dto.UserDetailDto
import com.husseinhj.customerinfoapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.anyInt
import org.mockito.MockitoAnnotations
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


class UserDetailUseCaseTest {

    @Mock
    private lateinit var userRepository: UserRepository
    private lateinit var userDetailUseCase: UserDetailUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        userDetailUseCase = UserDetailUseCase(userRepository)
    }

    @Test
    fun `when repository returns a list of users, emit success resource`(): Unit = runTest {
        val userDetail = UserDetailDto(
            firstName = "David",
            gender = Gender.MALE,
            id = 2,
            imageUrl = "",
            lastName = "Pffegen",
            phoneNumber = "",
            stickers = listOf(
                Sticker.Fam
            )
        )
        Mockito.`when`(userRepository.getUser(anyInt())).thenReturn(userDetail)

        userDetailUseCase(anyInt()).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    Assert.assertNotNull(result.data)
                }

                is Resource.Error -> {
                    Assert.assertNull(result.error)
                }

                is Resource.Loading -> {}
            }
        }.launchIn(this)
    }

    @Test
    fun `when repository throws HttpException, emit error resource with HTTP status code`() =
        runTest {
            val httpException = HttpException(
                Response.error<Any>(
                    401,
                    "Unauthorized".toResponseBody("text/plain".toMediaTypeOrNull())
                )
            )
            Mockito.`when`(userRepository.getUser(anyInt())).thenAnswer {
                throw httpException
            }

            userDetailUseCase(anyInt()).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        Assert.assertNull(result.data)
                    }

                    is Resource.Error -> {
                        Assert.assertNotNull(result.error)
                    }

                    is Resource.Loading -> {}
                }
            }.launchIn(this)
        }

    @Test
    fun `when repository throws IOException, emit error resource Could not reach the server`() =
        runTest {
            val ioException = IOException("Could not reach the server")
            Mockito.`when`(userRepository.getUser(anyInt())).thenAnswer {
                throw ioException
            }

            userDetailUseCase(anyInt()).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        Assert.assertNull(result.data)
                    }

                    is Resource.Error -> {
                        Assert.assertNotNull(result.error)
                    }

                    is Resource.Loading -> {}
                }
            }.launchIn(this)
        }

}