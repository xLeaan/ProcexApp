package com.procex.procexapp.presentation.screens.client.formulario.create

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.domain.useCase.formulario.FormularioUseCase
import com.procex.procexapp.domain.util.Resource
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
class ClientFormularioCreateViewModel @Inject constructor(
    private val formularioUseCase: FormularioUseCase,
    @ApplicationContext private val context: Context
    ): ViewModel() {

    var state by mutableStateOf(ClientFormularioCreateState())
        private set
    
    var formularioResponse by mutableStateOf<Resource<Formulario>?>(null)
        private set

    var errorMessage by mutableStateOf("")
        private set

    //imagenes
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    fun createFormulario() = viewModelScope.launch {
        if (isValid() && file != null ) {
            formularioResponse = Resource.Loading
            val result = formularioUseCase.createFormulario(state.toFormulario(), file!!)
            formularioResponse = result
        } else if (file === null) {
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
            tipo_documento = "",
            num_documento = "",
            sexo = "",
            fecha = "",
            telefono = "",
            antecedentes_medicos = "",
            RH = "",
            historial_familiar = "",
            medicamentos_ac = "",
            historial_vacunas = "",
            nota_uno = "",
            nota_dos = "",
            seguro = "",
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

    private val selectedDate = mutableStateOf(Calendar.getInstance())

    fun onFechaInput(year: Int, month: Int, dayOfMonth: Int) {
        val formattedDate = "$dayOfMonth-${month + 1}-$year"
        state = state.copy(fecha = formattedDate)
    }

    fun getFormattedDate(): String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.format(selectedDate.value.time)
    }

    fun onTelefonoInput(input: String){
        state = state.copy(telefono = input)
    }

    fun onAntecedentes_medicosInput(input: String){
        state = state.copy(antecedentes_medicos = input)
    }

    fun onRHInput(input: String){
        state = state.copy(RH = input)
    }

    fun onHistorial_familiarInput(input: String){
        state = state.copy(historial_familiar = input)
    }

    fun onMedicamentos_acInput(input: String){
        state = state.copy(medicamentos_ac = input)
    }

    fun onHistorial_vacunasInput(input: String){
        state = state.copy(historial_vacunas = input)
    }

    fun onNota_unoInput(input: String){
        state = state.copy(nota_uno = input)
    }

    fun onSeguroInput(input: String){
        state = state.copy(seguro = input)
    }

    fun isValid(): Boolean {
        if (state.telefono.length != 10) {
            Toast.makeText(context, "El télefono no es válido", Toast.LENGTH_SHORT).show()
            return false
        }
        if (state.name_med == "") {
            Toast.makeText(context, "Debe ingresar el nombre del médico", Toast.LENGTH_SHORT).show()
            return false
        }
        if (state.name == "") {
            Toast.makeText(context, "Debe ingresar el nombre del paciente", Toast.LENGTH_SHORT).show()
            return false
        }
        if (state.tipo_documento == "") {
            Toast.makeText(context, "Debe ingresar el tipo de documento", Toast.LENGTH_SHORT).show()
            return false
        }
        if (state.num_documento == "") {
            Toast.makeText(context, "Debe ingresar el numero de documento", Toast.LENGTH_SHORT).show()
            return false
        }
        if (state.fecha == "") {
            Toast.makeText(context, "Debe ingresar una fecha de nacimiento", Toast.LENGTH_SHORT).show()
            return false
        }
        if (state.sexo == "") {
            Toast.makeText(context, "Debe ingresar el género del paciente", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}