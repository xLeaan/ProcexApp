package com.procex.procexapp.presentation.screens.admin.formulario.create

import androidx.compose.foundation.background
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.procex.procexapp.presentation.components.DefaultTopBar
import com.procex.procexapp.presentation.screens.admin.formulario.create.components.AdminFormularioCreateContent
import com.procex.procexapp.presentation.screens.admin.formulario.create.components.CreateFormulario


@Composable
fun AdminFormularioCreateScreen(navController: NavHostController){
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
        AdminFormularioCreateContent(paddingValues = paddingValues)

    }
    CreateFormulario()
}
