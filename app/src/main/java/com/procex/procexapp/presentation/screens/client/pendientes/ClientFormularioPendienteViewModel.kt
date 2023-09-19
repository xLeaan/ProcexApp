package com.procex.procexapp.presentation.screens.client.pendientes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.domain.useCase.formulario.FormularioUseCase
import com.procex.procexapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientFormularioPendienteViewModel @Inject constructor(private val formularioUseCase: FormularioUseCase): ViewModel() {

    var formularioResponse by mutableStateOf<Resource<List<Formulario>>?>(null)
        private set

    private val formularioLocalList = mutableStateOf<List<Formulario>>(emptyList())

    var search by mutableStateOf("")
    var tipoDocumento by mutableStateOf("")


    init {
        findNotReady()
    }


    fun findNotReady() = viewModelScope.launch {
        formularioResponse = Resource.Loading
        formularioUseCase.findNotReady(estado = String()).collect { data ->
            formularioResponse = data
        }
    }

    fun getFormulario() = viewModelScope.launch {
        formularioResponse = Resource.Loading
        formularioUseCase.getFormulario().collect { data ->
            formularioResponse = data
            if (data is Resource.Success) {
                formularioLocalList.value = data.data // Guarda los datos localmente para filtrado offline
            }
        }
    }

    fun getFormularioByNum(num_documento: String) {
        viewModelScope.launch {
            val formulariosOffline = formularioLocalList.value.filter { formulario ->
                formulario.num_documento.contains(num_documento)
            }
            formularioResponse = Resource.Success(formulariosOffline)
        }
    }

    fun getFormularioByType(tipo_documento: String) {
        viewModelScope.launch {
            val formulariosOffline = formularioLocalList.value.filter { formulario ->
                formulario.tipo_documento == tipo_documento
            }
            formularioResponse = Resource.Success(formulariosOffline)
        }
    }

    fun getFormularioByTypeAndNum(tipo_documento: String, num_documento: String) {
        viewModelScope.launch {
            val formulariosOffline = formularioLocalList.value.filter { formulario ->
                formulario.tipo_documento == tipo_documento && formulario.num_documento.contains(num_documento)
            }
            formularioResponse = Resource.Success(formulariosOffline)
        }
    }

}