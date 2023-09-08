package com.procex.procexapp.presentation.screens.client.resumen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.procex.procexapp.presentation.components.DefaultTopBar
import com.procex.procexapp.presentation.navigation.Graph
import com.procex.procexapp.presentation.screens.client.info.components.InfoContent
import com.procex.procexapp.presentation.screens.client.pendientes.components.GetPendiente

@Composable
fun PendienteScreen(navController: NavHostController){
    Scaffold(
    ) { paddingValues ->
        GetPendiente(navController, paddingValues)
    }

}