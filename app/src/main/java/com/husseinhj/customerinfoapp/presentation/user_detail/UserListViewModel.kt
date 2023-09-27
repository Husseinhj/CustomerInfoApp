package com.husseinhj.customerinfoapp.presentation.user_detail

import javax.inject.Inject
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.onEach
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import com.husseinhj.customerinfoapp.common.Resource
import com.husseinhj.customerinfoapp.data.remote.dto.UserDetailDto
import com.husseinhj.customerinfoapp.domain.use_case.user_detail.UserDetailUseCase

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val userDetailUseCase: UserDetailUseCase
): ViewModel() {

    private val _state = MutableStateFlow(UserDetailState())
    val state: StateFlow<UserDetailState> = _state

    fun getUserDetail(id: Int) {
        userDetailUseCase.invoke(id).onEach { result ->
            when (result) {
                is Resource.Loading -> _state.value = UserDetailState(true)
                is Resource.Success -> {
                    _state.value = UserDetailState(user = result.data ?: UserDetailDto())
                }
                is Resource.Error -> {
                    _state.value = UserDetailState(error = result.error ?: "An unexpected error occurred!")
                }
            }
        }.launchIn(viewModelScope)
    }

}