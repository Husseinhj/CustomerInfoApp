package com.husseinhj.customerinfoapp.domain.use_case.user_list

import com.husseinhj.customerinfoapp.common.Resource
import com.husseinhj.customerinfoapp.data.remote.dto.Customer
import com.husseinhj.customerinfoapp.data.remote.dto.Gender
import com.husseinhj.customerinfoapp.data.remote.dto.Sticker
import com.husseinhj.customerinfoapp.data.remote.dto.UserListDto
import com.husseinhj.customerinfoapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class UserListUseCaseTest {

    @Mock
    private lateinit var userRepository: UserRepository
    private lateinit var userListUseCase: UserListUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        userListUseCase = UserListUseCase(userRepository)
    }

    @Test
    fun `when repository returns a list of users, emit success resource`(): Unit = runTest {
        val usersMock = UserListDto(
            listOf(
                Customer(
                    firstName = "Hussein",
                    gender = Gender.MALE,
                    id = 1,
                    imageUrl = "",
                    lastName = "Habibi",
                    phoneNumber = "",
                    stickers = listOf()
                ),
                Customer(
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
            )
        )
        `when`(userRepository.getUsers()).thenReturn(usersMock)

        userListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    assertNotNull(result.data)
                    assertEquals(2, result.data!!.size)
                }

                is Resource.Error -> {
                    assertNull(result.error)
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
            `when`(userRepository.getUsers()).thenThrow(httpException)

            userListUseCase().onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        assertNull(result.data)
                    }

                    is Resource.Error -> {
                        assertNotNull(result.error)
                    }

                    is Resource.Loading -> {}
                }
            }.launchIn(this)
        }

    @Test
    fun `when repository throws IOException, emit error resource Could not reach the server`() =
        runTest {
            val ioException = IOException("Could not reach the server")
            `when`(userRepository.getUsers()).thenAnswer {
                throw ioException
            }

            userListUseCase().onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        assertNull(result.data)
                    }

                    is Resource.Error -> {
                        assertNotNull(result.error)
                    }

                    is Resource.Loading -> {}
                }
            }.launchIn(this)
        }
}