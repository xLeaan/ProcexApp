package com.procex.procexapp.presentation.screens.admin.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.procex.procexapp.presentation.screens.admin.home.components.AdminBottomBar
import com.procex.procexapp.presentation.navigation.graph.admin.AdminNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminHomeScreen(navController: NavHostController = rememberNavController()){
    Scaffold(
        bottomBar = { AdminBottomBar(navController = navController) }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
        AdminNavGraph(navController = navController)

    }
}