package com.procex.procexapp.presentation.screens.client.resumen

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
class ClientFormularioResumenViewModel @Inject constructor(private val formularioUseCase: FormularioUseCase): ViewModel() {

    var formularioRespone by mutableStateOf<Resource<List<Formulario>>?>(null)
        private set

    var countFormulariosM1 by mutableStateOf(0)
        private set

    var countFormulariosM2 by mutableStateOf(0)
        private set

    var countFormulariosF by mutableStateOf(0)
        private set

    var countFormulariosM by mutableStateOf(0)
        private set

    var countFormulariosE by mutableStateOf(0)
        private set

    var countFormulariosNE by mutableStateOf(0)
        private set

    init {
        getVisitas()
        getFormularioMes1()
        getFormularioMes2()
        findBySexoF()
        findBySexoM()
        findVisitasEfectivas()
        findVisitasNoEfectivas()
    }

    fun getVisitas() = viewModelScope.launch {
        formularioRespone = Resource.Loading
        formularioUseCase.getFormulario().collect { data ->
            formularioRespone = data
        }
    }

    fun getFormularioMes1() = viewModelScope.launch {
        formularioRespone = Resource.Loading
        formularioUseCase.findByMes1(created_at = String()).collect { data ->
            formularioRespone = data

            if (data is Resource.Success) {
                countFormulariosM1 = data.data.size
            } else {
                countFormulariosM1 = 0
            }
        }
    }

    fun getFormularioMes2() = viewModelScope.launch {
        formularioRespone = Resource.Loading
        formularioUseCase.findByMes2(created_at = String()).collect { data ->
            formularioRespone = data

            if (data is Resource.Success) {
                countFormulariosM2 = data.data.size
            } else {
                countFormulariosM2 = 0
            }
        }
    }

    fun findBySexoF() = viewModelScope.launch {
        formularioRespone = Resource.Loading
        formularioUseCase.findBySexoF(sexo = String()).collect { data ->
            formularioRespone = data

            if (data is Resource.Success) {
                countFormulariosF = data.data.size
            } else {
                countFormulariosF = 0
            }
        }
    }


    fun findBySexoM() = viewModelScope.launch {
            formularioRespone = Resource.Loading
            formularioUseCase.findBySexoM(sexo = String()).collect { data ->
                formularioRespone = data

                if (data is Resource.Success) {
                    countFormulariosM = data.data.size
                } else {
                    countFormulariosM = 0
                }
            }
    }

    fun findVisitasEfectivas() = viewModelScope.launch {
        formularioRespone = Resource.Loading
        formularioUseCase.findVisitasEfectivas(cl_visita = String()).collect { data ->
            formularioRespone = data

            if (data is Resource.Success) {
                countFormulariosE = data.data.size
            } else {
                countFormulariosE = 0
            }
        }
    }

    fun findVisitasNoEfectivas() = viewModelScope.launch {
        formularioRespone = Resource.Loading
        formularioUseCase.findVisitasNoEfectivas(cl_visita = String()).collect { data ->
            formularioRespone = data

            if (data is Resource.Success) {
                countFormulariosNE = data.data.size
            } else {
                countFormulariosNE = 0
            }
        }
    }

}