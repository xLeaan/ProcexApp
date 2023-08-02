package com.procex.procexapp.presentation.screens.client.formulario.update.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.procex.procexapp.domain.util.Resource
import com.procex.procexapp.presentation.components.ProgressBar
import com.procex.procexapp.presentation.screens.admin.formulario.update.AdminFormularioUpdateViewModel
import com.procex.procexapp.presentation.screens.admin.list.AdminFormularioListViewModel
import com.procex.procexapp.presentation.screens.client.formulario.update.ClientFormularioUpdateViewModel
import com.procex.procexapp.presentation.screens.client.list.ClientFormularioListViewModel

@Composable
fun UpdateFormulario(vm: ClientFormularioUpdateViewModel = hiltViewModel(), vmList: ClientFormularioListViewModel = hiltViewModel()){

    when(val response = vm.formularioResponse){
        Resource.Loading -> {
           ProgressBar()
        }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                vmList.getFormulario()
            }
            Toast.makeText(LocalContext.current, "Los datos se han actualizado correctamente" , Toast.LENGTH_LONG).show()

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