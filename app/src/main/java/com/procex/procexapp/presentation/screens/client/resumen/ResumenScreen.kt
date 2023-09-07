package com.procex.procexapp.presentation.screens.client.resumen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.presentation.screens.client.resumen.components.GetResumen

@Composable
fun ResumenScreen(navController: NavHostController, formulario: List<Formulario>){
    Scaffold() {paddingValues ->
        GetResumen(paddingValues)
    }


}