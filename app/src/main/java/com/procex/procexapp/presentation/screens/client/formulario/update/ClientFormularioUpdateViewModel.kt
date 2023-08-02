package com.procex.procexapp.presentation.screens.client.formulario.update

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.domain.useCase.formulario.FormularioUseCase
import com.procex.procexapp.domain.util.Resource
import com.procex.procexapp.presentation.screens.client.formulario.update.mapper.toFormulario
import com.procex.procexapp.presentation.util.ComposeFileProvider
import com.procex.procexapp.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import androidx.compose.runtime.*
import com.procex.procexapp.presentation.screens.client.formulario.create.mapper.toFormulario
import javax.inject.Inject

@HiltViewModel
class ClientFormularioUpdateViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val formularioUseCase: FormularioUseCase,
    @ApplicationContext private val context: Context
    ): ViewModel() {


    var state by mutableStateOf(ClientFormularioUpdateState())
        private set
    
    var formularioResponse by mutableStateOf<Resource<Formulario>?>(null)
        private set

    //imagenes
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    var data = savedStateHandle.get<String>("formulario")
    val formulario = Formulario.fromJson(data!!)

    init {
        state = state.copy(
            consulta = formulario.consulta,
            name_med = formulario.name_med,
            name = formulario.name,
            tipo_documento = formulario.tipo_documento,
            num_documento = formulario.num_documento,
            sexo = formulario.sexo,
            fecha = formulario.fecha,
            telefono = formulario.telefono,
            antecedentes_medicos = formulario.antecedentes_medicos,
            RH = formulario.RH,
            historial_familiar = formulario.historial_familiar,
            medicamentos_ac = formulario.medicamentos_ac,
            historial_vacunas = formulario.historial_vacunas,
            nota_uno = formulario.nota_uno,
            nota_dos = formulario.nota_dos ?: "",
            seguro = formulario.seguro,
            image = formulario.image!!
        )
    }


    fun onUpdate() {
        if(file != null){
            updateFormularioWithImage()
        }
        else {
            updateFormulario()
        }
    }


    fun updateFormulario() = viewModelScope.launch {
        formularioResponse = Resource.Loading
        val result = formularioUseCase.updateFormulario(formulario.id ?: "", state.toFormulario())
        formularioResponse = result
    }

    fun updateFormularioWithImage() = viewModelScope.launch {
        formularioResponse = Resource.Loading
        val result = formularioUseCase.updateFormularioWithImage(formulario.id ?: "", state.toFormulario(), file!!)
        formularioResponse = result
    }

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

    fun onNota_dosInput(input: String){
        state = state.copy(nota_dos = input)
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
        return true
    }

}