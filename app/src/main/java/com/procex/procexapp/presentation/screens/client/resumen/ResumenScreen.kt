package com.procex.procexapp.presentation.screens.client.resumen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.procex.procexapp.presentation.screens.client.resumen.components.ResumenContent

@Composable
fun ResumenScreen(navController: NavHostController){
    Scaffold() {paddingValues ->
        ResumenContent(paddingValues = paddingValues, navController = navController)
    }
}