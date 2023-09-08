package com.procex.procexapp.presentation.screens.client.pendientes.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.procex.procexapp.domain.util.Resource
import com.procex.procexapp.presentation.components.ProgressBar
import com.procex.procexapp.presentation.screens.client.list.ClientFormularioListViewModel
import com.procex.procexapp.presentation.screens.client.list.components.ClientFormularioListContent
import com.procex.procexapp.presentation.screens.client.resumen.ClientFormularioListoViewModel
import com.procex.procexapp.presentation.screens.client.resumen.components.ListoContent

@Composable
fun GetListo(navController: NavHostController,
             paddingValues: PaddingValues,
             vm: ClientFormularioListoViewModel = hiltViewModel()
) {
    when (val response = vm.formularioResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            ListoContent(
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