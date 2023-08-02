package com.procex.procexapp.presentation.screens.profile.info

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.procex.procexapp.domain.model.User
import com.procex.procexapp.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var user by mutableStateOf < User? >(null)
        private set

    init {
        getSessionData()
    }


    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect(){ data ->
            user = data.user
        }
    }

    fun logout() = viewModelScope.launch {
        authUseCase.logout()
    }

}