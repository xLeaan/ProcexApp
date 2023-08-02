package com.procex.procexapp.presentation.screens.client.list

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.domain.useCase.formulario.FormularioUseCase
import com.procex.procexapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientFormularioListViewModel @Inject constructor(private val formularioUseCase: FormularioUseCase): ViewModel() {

    var formularioResponse by mutableStateOf<Resource<List<Formulario>>?>(null)
        private set

    var search by mutableStateOf("")
    var tipoDocumento by mutableStateOf("")


    fun getFormulario() = viewModelScope.launch {
        formularioResponse = Resource.Loading
        formularioUseCase.getFormulario().collect(){ data ->
            formularioResponse = data
        }
    }

    fun getFormularioByNum(num_documento: String) = viewModelScope.launch {
        formularioResponse = Resource.Loading
        formularioUseCase.findByNum(num_documento).collect(){
            Log.d("ClientFormularioListViewModel", "Data: $it")
            formularioResponse = it
        }
    }

    fun getFormularioByType(tipo_documento: String) = viewModelScope.launch {
        formularioResponse = Resource.Loading
        formularioUseCase.findByType(tipo_documento).collect(){
            Log.d("ClientFormularioListViewModel", "Data: $it")
            formularioResponse = it
        }
    }

    fun getFormularioByTypeAndNum(tipo_documento: String, numero_documento: String) = viewModelScope.launch {
        formularioResponse = Resource.Loading
        formularioUseCase.findByTypeAndNum(tipo_documento, numero_documento).collect {
            Log.d("ClientFormularioListViewModel", "Data: $it")
            formularioResponse = it
        }
    }

    fun onSearchInput(value: String) {
        search = value
    }

    fun onTipoDocumentoInput(value: String) {
        tipoDocumento = value
    }


}