package com.procex.procexapp.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.procex.procexapp.domain.model.AuthResponse
import com.procex.procexapp.domain.useCase.auth.AuthUseCase
import com.procex.procexapp.domain.util.Resource
import com.procex.procexapp.presentation.screens.auth.register.mapper.toUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")

    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun register() = viewModelScope.launch {
        if(isValidForm()) {
            registerResponse = Resource.Loading
            val result = authUseCase.register(state.toUser())
            registerResponse = result // DATA / ERROR
        }

    }

    fun onNameInput(input: String){
        state = state.copy(name = input)
    }

    fun onLastnameInput(input: String){
        state = state.copy(lastname = input)
    }

    fun onEmailInput(input: String){
        state = state.copy(email = input)
    }

    fun onPhoneInput(input: String){
        state = state.copy(phone = input)
    }

    fun onPasswordInput(input: String){
        state = state.copy(password = input)
    }

    fun onConfirmPasswordInput(input: String){
        state = state.copy(confirmPassword = input)
    }

    fun isValidForm(): Boolean {
        if(state.name == ""){
            errorMessage = "El campo de nombre no puede estar vacío"
            return false
        }
        else if(state.lastname == ""){
            errorMessage = "El campo de apellido no puede estar vacío"
            return false
        }
        else if(state.email == ""){
            errorMessage = "El campo de email no puede estar vacío"
            return false
        }
        else if(state.phone == ""){
            errorMessage = "El campo de telefono no puede estar vacío"
            return false
        }
        else if(state.password == ""){
            errorMessage = "El campo de contraseña no puede estar vacío"
            return false
        }
        else if(state.confirmPassword == ""){
            errorMessage = "El campo de confimar contraseña no puede estar vacío"
            return false
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El email no es válido"
            return false
        }
        else if(state.password.length < 6){
            errorMessage = "La constraseña debe tener al menos 6 caracteres"
            return false
        }
        else if(state.password != state.confirmPassword){
            errorMessage = "Las constraseñas no coinciden"
            return false
        }

        return true
    }
}