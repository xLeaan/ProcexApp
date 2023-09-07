package com.procex.procexapp.presentation.screens.client.resumen.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.procex.procexapp.domain.util.Resource
import com.procex.procexapp.presentation.components.ProgressBar
import com.procex.procexapp.presentation.screens.client.resumen.ClientFormularioPendienteViewModel
import com.procex.procexapp.presentation.screens.client.resumen.ClientFormularioResumenViewModel

@Composable
fun GetResumen(paddingValues: PaddingValues, vm: ClientFormularioResumenViewModel = hiltViewModel()) {

    when(val response = vm.formularioRespone){
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            ResumenContent(formulario = response.data, paddingValues = PaddingValues())

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