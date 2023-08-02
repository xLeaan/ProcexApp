package com.procex.procexapp.presentation.screens.admin.formulario.update

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.procex.procexapp.presentation.components.DefaultTopBar
import com.procex.procexapp.presentation.screens.admin.formulario.update.components.AdminFormularioUpdateContent
import com.procex.procexapp.presentation.screens.admin.formulario.update.components.UpdateFormulario

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminFormularioUpdateScreen(navController: NavHostController, formularioParam: String){

    Log.d("AdminFormularioUpdateScreen", "Data: $formularioParam")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar formulario",
                upAvailable = true,
                navController = navController
            )
        },
        modifier = Modifier.background(Color.LightGray)
    ) { paddingValues ->
        AdminFormularioUpdateContent(paddingValues = paddingValues)
    }
    UpdateFormulario()
}
