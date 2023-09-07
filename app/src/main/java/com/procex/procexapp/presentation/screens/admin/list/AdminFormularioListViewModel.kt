package com.procex.procexapp.presentation.screens.admin.list

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
class AdminFormularioListViewModel @Inject constructor(private val formularioUseCase: FormularioUseCase): ViewModel() {

    var formularioResponse by mutableStateOf<Resource<List<Formulario>>?>(null)
        private set

    var deleteFormularioResponse by mutableStateOf<Resource<Unit>?>(null)
        private set

    var search by mutableStateOf("")
    var estado by mutableStateOf("")
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
            formularioResponse = it
        }
    }

    fun getFormularioByType(tipo_documento: String) = viewModelScope.launch {
        formularioResponse = Resource.Loading
        formularioUseCase.findByType(tipo_documento).collect(){ result ->
            formularioResponse = result
        }
    }

    fun getFormularioByTypeAndNum(tipo_documento: String, numero_documento: String) = viewModelScope.launch {
        formularioResponse = Resource.Loading
        formularioUseCase.findByTypeAndNum(tipo_documento, numero_documento).collect { result ->
            formularioResponse = result
        }
    }

    fun onSearchInput(value: String) {
        search = value
    }

    fun onTipoDocumentoInput(value: String) {
        tipoDocumento = value
    }

    fun deleteFormulario(id: String) = viewModelScope.launch {
        deleteFormularioResponse = Resource.Loading
        val result = formularioUseCase.deleteFormulario(id)
        deleteFormularioResponse = result
    }
}