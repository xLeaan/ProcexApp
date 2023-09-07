package com.procex.procexapp.presentation.screens.client.resumen

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
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.presentation.navigation.Graph
import com.procex.procexapp.presentation.screens.client.list.components.GetFormularioReady
import com.procex.procexapp.presentation.screens.client.pendientes.components.GetPendiente
import com.procex.procexapp.presentation.screens.client.resumen.components.GetResumen

@Composable
fun PendienteScreen(navController: NavHostController){
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            modifier = Modifier.padding(bottom = 60.dp),
            onClick = { navController.navigate(route = Graph.INFO) }
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "",
                tint = Color.Blue
            )
        }
    }){paddingValues ->
        GetPendiente(navController, paddingValues)

    }

}