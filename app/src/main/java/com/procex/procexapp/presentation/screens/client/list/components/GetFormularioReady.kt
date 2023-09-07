package com.procex.procexapp.presentation.screens.client.list.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.procex.procexapp.domain.util.Resource
import com.procex.procexapp.presentation.components.ProgressBar
import com.procex.procexapp.presentation.screens.client.list.ClientFormularioListViewModel


@Composable
fun GetFormularioReady(
    navController: NavHostController,
    paddingValues: PaddingValues,
    vm: ClientFormularioListViewModel = hiltViewModel()
) {
    when (val response = vm.formularioResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            ClientFormularioListContent(
                paddingValues,
                navController,
                formulario = response.data
            )
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo un error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}


