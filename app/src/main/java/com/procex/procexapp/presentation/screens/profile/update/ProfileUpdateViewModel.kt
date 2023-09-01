package com.procex.procexapp.presentation.screens.profile.update

import android.content.Context
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.procex.procexapp.domain.model.User
import com.procex.procexapp.domain.useCase.auth.AuthUseCase
import com.procex.procexapp.domain.useCase.users.UsersUseCase
import com.procex.procexapp.domain.util.Resource
import com.procex.procexapp.presentation.screens.profile.update.mapper.toUser
import com.procex.procexapp.presentation.util.ComposeFileProvider
import com.procex.procexapp.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val usersUseCase: UsersUseCase,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext private val context: Context
    ): ViewModel() {

    var state by mutableStateOf(ProfileUpdateState())

    // ARGUMENTOS
    val data = savedStateHandle.get<String>("user")
    var user = User.fromJson(data!!)

    //IMAGENES
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    var updateResponse by mutableStateOf<Resource<User>?>(null)
        private set

    init {
        state = state.copy(
            name = user.name,
            lastname = user.lastname,
            img = user.img?: ""
        )
    }

    fun updateUserSession(userResponse: User) = viewModelScope.launch {
        authUseCase.updateSession(userResponse)
    }

    fun onUpdate(){
        if(file != null) { //seleccionó una imagen
            updateWithImage()
        } else {
            update()
        }
    }

    fun updateWithImage() = viewModelScope.launch {
        updateResponse = Resource.Loading
        val result = usersUseCase.updateUserWithImage(user.id ?: "", state.toUser(), file!!)
        updateResponse = result
    }

    fun update() = viewModelScope.launch {
        updateResponse = Resource.Loading
        val result = usersUseCase.updateUser(user.id ?: "", state.toUser())
        updateResponse = result
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null){
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(img = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch{
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null){
            state = state.copy(img = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.img)
        }
    }


    fun onNameInput(input: String){
        state = state.copy(name = input)
    }

    fun onLastnameInput(input: String){
        state = state.copy(lastname = input)
    }

    fun onImgInput(input: String){
        state = state.copy(img = input)
    }

}