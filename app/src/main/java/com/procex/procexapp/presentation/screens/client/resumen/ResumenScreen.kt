package com.procex.procexapp.presentation.screens.client.resumen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.presentation.navigation.Graph
import com.procex.procexapp.presentation.screens.client.pendientes.components.GetListo
import com.procex.procexapp.presentation.screens.client.resumen.components.GetResumen
import com.procex.procexapp.presentation.ui.Blue200
import com.procex.procexapp.presentation.ui.Gray200
import com.procex.procexapp.presentation.ui.Green10
import com.procex.procexapp.presentation.ui.Green40
import com.procex.procexapp.presentation.ui.Purple40
import com.procex.procexapp.presentation.ui.Red100
import com.procex.procexapp.presentation.ui.Red200

@Composable
fun ResumenScreen(navController: NavHostController, formulario: List<Formulario>){
    Scaffold()
    {paddingValues ->
        GetResumen(paddingValues)

    }
}