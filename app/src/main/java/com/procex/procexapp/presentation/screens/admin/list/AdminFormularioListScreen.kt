package com.procex.procexapp.presentation.screens.admin.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.procex.procexapp.presentation.components.DefaultSearchView
import com.procex.procexapp.presentation.screens.admin.list.components.DeleteFormulario
import com.procex.procexapp.presentation.screens.admin.list.components.GetFormulario
import com.procex.procexapp.presentation.navigation.Graph


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminFormularioListScreen(navController: NavHostController, vm: AdminFormularioListViewModel = hiltViewModel()){

    vm.getFormulario()

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
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 60.dp),
                onClick = { navController.navigate(route = Graph.ADMIN_FORMULARIO) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.Blue
                )
            }
        }
    ) { paddingValues ->
        GetFormulario(
            navController,
            paddingValues
        )
    }
    DeleteFormulario()
}

