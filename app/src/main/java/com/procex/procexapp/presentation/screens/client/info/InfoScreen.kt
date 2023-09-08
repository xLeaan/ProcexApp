package com.procex.procexapp.presentation.screens.client.info

import androidx.compose.foundation.background
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.procex.procexapp.presentation.components.DefaultTopBar
import com.procex.procexapp.presentation.screens.client.formulario.create.components.ClientFormularioCreateContent
import com.procex.procexapp.presentation.screens.client.info.components.InfoContent
import com.procex.procexapp.presentation.screens.profile.info.components.ProfileContent

@Composable
fun InfoScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Información",
                upAvailable = true,
                navController = navController
            )
        },
        modifier = Modifier.background(Color.LightGray)
    ) { paddingValues ->
       InfoContent(paddingValues = paddingValues)
    }
}