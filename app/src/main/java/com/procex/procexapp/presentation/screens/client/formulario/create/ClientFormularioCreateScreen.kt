package com.procex.procexapp.presentation.screens.client.formulario.create

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.procex.procexapp.presentation.components.DefaultTopBar
import com.procex.procexapp.presentation.screens.client.formulario.create.components.CreateFormulario
import com.procex.procexapp.presentation.screens.client.formulario.create.components.ClientFormularioCreateContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientFormularioCreateScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Ficha médica",
                upAvailable = true,
                navController = navController
            )
        },
        modifier = Modifier.background(Color.LightGray)
    ) { paddingValues ->
        ClientFormularioCreateContent(paddingValues = paddingValues)
    }
    CreateFormulario()
}
