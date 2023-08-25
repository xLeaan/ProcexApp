package com.procex.procexapp.presentation.screens.admin.formulario.create

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.domain.useCase.formulario.FormularioUseCase
import com.procex.procexapp.domain.util.Resource
import com.procex.procexapp.presentation.screens.admin.formulario.create.mapper.toFormulario
import com.procex.procexapp.presentation.screens.client.formulario.create.mapper.toFormulario
import com.procex.procexapp.presentation.util.ComposeFileProvider
import com.procex.procexapp.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class AdminFormularioCreateViewModel @Inject constructor(
    private val formularioUseCase: FormularioUseCase,
    @ApplicationContext private val context: Context
    ): ViewModel() {

    var state by mutableStateOf(AdminFormularioCreateState())
        private set
    
    var formularioResponse by mutableStateOf<Resource<Formulario>?>(null)
        private set

    //imagenes
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    fun createFormulario() = viewModelScope.launch {
        if (isValid() && file != null ) {
            formularioResponse = Resource.Loading
            val result = formularioUseCase.createFormulario(state.toFormulario(), file!!)
            formularioResponse = result
        } else {
            Toast.makeText(context, "Es necesario una imagen para cargar el formulario", Toast.LENGTH_SHORT).show()
        }
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null){
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch{
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null){
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)
        }
    }
    fun clearForm(){
        state = state.copy(
            consulta = "",
            name_med = "",
            name = "",
            sexo = "",
            RH = "",
            fecha = "",
            telefono = "",
            tipo_visita = "",
            cl_visita = "",
            causa = "",
            direccion = "",
            barrio = "",
            propiedad = "",
            tensiona = "",
            tipo_ta = "",
            toma_ta = "",
            resultado_ta = "",
            oximetria = "",
            toma_oxi = "",
            resultado_oxi = "",
            findrisk = "",
            estatura = "",
            peso = "",
            nota_uno = "",
            image = ""
        )
        formularioResponse = null
    }

    fun onConsultaInput(input: String){
        state = state.copy(consulta = input)
    }

    fun onName_medInput(input: String){
        state = state.copy(name_med = input)
    }

    fun onNameInput(input: String){
        state = state.copy(name = input)
    }

    fun onTipo_documentoInput(input: String){
        state = state.copy(tipo_documento = input)
    }

    fun onNum_documentoInput(input: String){
        state = state.copy(num_documento = input)
    }

    fun onSexoInput(input: String){
        state = state.copy(sexo = input)
    }

    fun onRHInput(input: String){
        state = state.copy(RH = input)
    }

    fun onFechaInput(year: Int, month: Int, dayOfMonth: Int) {
        val formattedDate = "$dayOfMonth-${month + 1}-$year"
        state = state.copy(fecha = formattedDate)
    }

    fun onTelefonoInput(input: String){
        state = state.copy(telefono = input)
    }

    fun onTipo_visitaInput(input: String){
        state = state.copy(tipo_visita = input)
    }

    fun onCl_visitaInput(input: String){
        state = state.copy(cl_visita = input)
    }

    fun onCausaInput(input: String){
        state = state.copy(causa = input)
    }

    fun onDireccionInput(input: String){
        state = state.copy(direccion = input)
    }

    fun onBarrioInput(input: String){
        state = state.copy(barrio = input)
    }

    fun onPropiedadInput(input: String){
        state = state.copy(propiedad = input)
    }

    fun onTensionaInput(input: String){
        state = state.copy(tensiona = input)
    }

    fun onTipo_taInput(input: String){
        state = state.copy(tipo_ta = input)
    }

    fun onToma_taInput(year: Int, month: Int, dayOfMonth: Int) {
        val formattedDate = "$dayOfMonth-${month + 1}-$year"
        state = state.copy(toma_ta = formattedDate)
    }

    fun onResultado_taInput(year: Int, month: Int, dayOfMonth: Int) {
        val formattedDate = "$dayOfMonth-${month + 1}-$year"
        state = state.copy(resultado_ta = formattedDate)
    }

    fun onOximetriaInput(input: String){
        state = state.copy(oximetria = input)
    }

    fun onToma_oxiInput(year: Int, month: Int, dayOfMonth: Int) {
        val formattedDate = "$dayOfMonth-${month + 1}-$year"
        state = state.copy(toma_oxi = formattedDate)
    }

    fun onResultado_oxiInput(year: Int, month: Int, dayOfMonth: Int) {
        val formattedDate = "$dayOfMonth-${month + 1}-$year"
        state = state.copy(resultado_oxi = formattedDate)
    }

    fun onFindriskInput(input: String){
        state = state.copy(findrisk = input)
    }

    fun onEstaturaInput(input: String){
        state = state.copy(estatura = input)
    }

    fun onPesoInput(input: String){
        state = state.copy(peso = input)
    }

    fun onNota_unoInput(input: String){
        state = state.copy(nota_uno = input)
    }

    fun isValid(): Boolean {
        if (state.telefono.length > 13 || state.telefono.length < 7) {
            Toast.makeText(context, "El télefono no es válido", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}