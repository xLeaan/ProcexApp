package com.procex.procexapp.presentation.screens.client.list

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.procex.procexapp.presentation.components.DefaultSearchView
import com.procex.procexapp.presentation.navigation.Graph
import com.procex.procexapp.presentation.screens.client.list.components.GetFormulario
import com.procex.procexapp.presentation.ui.Blue200
import com.procex.procexapp.presentation.ui.Gray200
import com.procex.procexapp.presentation.ui.Green20
import com.procex.procexapp.presentation.ui.Green30
import com.procex.procexapp.presentation.ui.Green40
import com.procex.procexapp.presentation.ui.Purple40
import com.procex.procexapp.presentation.ui.PurpleGrey80
import com.procex.procexapp.presentation.ui.Red200
import com.procex.procexapp.presentation.ui.White10


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientFormularioListScreen(navController: NavHostController, vm: ClientFormularioListViewModel = hiltViewModel()) {

    val shape = CircleShape
    val buttonSize = 38.dp

    Scaffold(
        topBar = {
            DefaultSearchView(
                value = vm.search,
                onValueChange = { text ->
                    vm.onSearchInput(text)
                },
                onTipoDocumentoChange = { selectedTP ->
                    vm.onTipoDocumentoInput(selectedTP)
                },
                navController = navController,
                onClick = {
                    if (vm.tipoDocumento.isNotBlank() && vm.search.isNotBlank()) {
                        vm.getFormularioByTypeAndNum(vm.tipoDocumento, vm.search)
                    } else if (vm.tipoDocumento.isNotBlank()) {
                        vm.getFormularioByType(vm.tipoDocumento)
                    } else if (vm.search.isNotBlank()) {
                        vm.getFormularioByNum(vm.search)
                    }
                }
            )
        },
        floatingActionButton = {
            Column(
                modifier = Modifier.padding(bottom = 60.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                FloatingActionButton(
                    onClick = { navController.navigate(route = Graph.LISTO) },
                    modifier = Modifier.size(buttonSize).clip(shape),
                    backgroundColor = PurpleGrey80
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "",
                        tint = Purple40
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                FloatingActionButton(
                    onClick = { navController.navigate(route = Graph.PENDIENTE) },
                    modifier = Modifier.size(buttonSize).clip(shape),
                    backgroundColor = White10
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "",
                        tint = Red200
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                FloatingActionButton(
                    onClick = { navController.navigate(route = Graph.CLIENT_FORMULARIO) },
                    backgroundColor = Green30
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "",
                        tint = Green20
                    )
                }
            }
        }

    ) { paddingValues ->
        GetFormulario(navController, paddingValues)
    }
}
