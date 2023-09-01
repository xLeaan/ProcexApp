package com.procex.procexapp.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.procex.procexapp.domain.model.AuthResponse
import com.procex.procexapp.domain.useCase.auth.AuthUseCase
import com.procex.procexapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")

    //LOGIN RESPONSE
    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    init {
        getSessionData()
    }



    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect(){ data ->
            if(!data.token.isNullOrBlank()){
                loginResponse = Resource.Success(data)
            }
        }
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }


    fun login() = viewModelScope.launch {
        if(isValidForm()) {
            loginResponse = Resource.Loading // ESPERANDO
            val result = authUseCase.login(state.documento, state.password) // RETORNA UNA RESPUESTA
            loginResponse = result // EXITOSA / ERROR
            Log.d("LoginViewModel", "Response: ${loginResponse}")
        }
    }


    fun onDocumentoInput(documento: String){
        state = state.copy(documento = documento)
    }

    fun onPasswordlInput(password: String){
        state = state.copy(password = password)
    }

    fun isValidForm(): Boolean {
        if (!state.documento.matches(Regex("\\d+"))) {
            errorMessage = "El documento no es válido"
            return false
        }
        else if(state.password.length < 6){
            errorMessage = "La constraseña debe tener al menos 6 caracteres"
            return false
        }
        return true

    }
}