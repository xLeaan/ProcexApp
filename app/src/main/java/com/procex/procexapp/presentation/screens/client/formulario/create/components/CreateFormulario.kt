package com.procex.procexapp.presentation.screens.client.formulario.create.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.procex.procexapp.domain.util.Resource
import com.procex.procexapp.presentation.components.ProgressBar
import com.procex.procexapp.presentation.screens.client.formulario.create.ClientFormularioCreateViewModel

@Composable
fun CreateFormulario( vm: ClientFormularioCreateViewModel = hiltViewModel()){

    when(val response = vm.formularioResponse){
        Resource.Loading -> {
           ProgressBar()
        }
        is Resource.Success -> {
            vm.clearForm()
            Toast.makeText(LocalContext.current, "Los datos se han creado correctamente" , Toast.LENGTH_LONG).show()

        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if(response != null){
            Toast.makeText(LocalContext.current, "Hubo un error desconocido", Toast.LENGTH_LONG).show()
        }
        }
    }

}