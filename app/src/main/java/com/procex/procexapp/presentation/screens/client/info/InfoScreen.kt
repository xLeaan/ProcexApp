package com.procex.procexapp.presentation.screens.client.info

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.procex.procexapp.presentation.screens.client.info.components.InfoContent
import com.procex.procexapp.presentation.screens.profile.info.components.ProfileContent

@Composable
fun InfoScreen(navController: NavHostController){
    Scaffold() {paddingValues ->
        InfoContent(paddingValues = paddingValues, navController = navController)
    }
}