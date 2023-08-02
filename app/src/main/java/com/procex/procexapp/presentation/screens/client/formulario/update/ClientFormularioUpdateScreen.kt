package com.procex.procexapp.presentation.screens.client.formulario.update

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.procex.procexapp.presentation.components.DefaultTopBar
import com.procex.procexapp.presentation.screens.client.formulario.update.components.UpdateFormulario
import com.procex.procexapp.presentation.screens.client.formulario.update.components.ClientFormularioUpdateContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientFormularioUpdateScreen(navController: NavHostController, formularioParam: String){
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Visualización",
                upAvailable = true,
                navController = navController
            )
        },
        modifier = Modifier.background(Color.LightGray)
    ) { paddingValues ->
        ClientFormularioUpdateContent(paddingValues = paddingValues)
    }
    UpdateFormulario()
}
