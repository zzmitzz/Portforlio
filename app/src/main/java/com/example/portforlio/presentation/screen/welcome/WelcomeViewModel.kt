package com.example.portforlio.presentation.screen.welcome

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

data class UserInformation(
    val id: String = "",
    val name: String = "",
    val age: Int? = null
)


class WelcomeViewModel(
) : ViewModel() {
    private val _userInformationFlow = MutableStateFlow(UserInformation())
    val userInformationFlow = _userInformationFlow
//    var userID: String = checkNotNull(savedStateHandle["userID"])
    init {

    }
    fun fakeFetchData(userID: String){
        viewModelScope.launch {
            delay(2000L)
            _userInformationFlow.value = UserInformation(userID,"John Doe", 25)
        }
    }

}