package com.husseinhj.customerinfoapp.presentation.user_list

import javax.inject.Inject
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.onEach
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import com.husseinhj.customerinfoapp.common.Resource
import com.husseinhj.customerinfoapp.domain.use_case.user_list.UserListUseCase

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userListUseCase: UserListUseCase
): ViewModel() {

    private val _state = MutableStateFlow(UserListState())
    val state: StateFlow<UserListState> = _state

    init {
        getUsers()
    }

    private fun getUsers() {
        userListUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Loading -> _state.value = UserListState(true)
                is Resource.Success -> {
                    _state.value = UserListState(users = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = UserListState(error = result.error ?: "An unexpected error occurred!")
                }
            }
        }.launchIn(viewModelScope)
    }

}