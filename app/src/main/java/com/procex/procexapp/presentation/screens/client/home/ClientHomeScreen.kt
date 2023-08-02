package com.procex.procexapp.presentation.screens.client.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.procex.procexapp.presentation.screens.client.home.components.ClientBottomBar
import com.procex.procexapp.presentation.navigation.graph.client.ClientNavGraph


@Composable
fun ClientHomeScreen(navController: NavHostController = rememberNavController()){
    Scaffold(
        bottomBar = { ClientBottomBar(navController = navController) }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
        ClientNavGraph(navController = navController)

    }
}