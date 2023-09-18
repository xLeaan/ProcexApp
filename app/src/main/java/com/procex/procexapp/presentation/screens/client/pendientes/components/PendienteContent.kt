package com.procex.procexapp.presentation.screens.client.pendientes.components


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.presentation.screens.client.pendientes.components.ClientPendienteItem

@Composable
fun PendienteContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    formulario: List<Formulario>
) {
    val formularioCount = formulario.size

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
            .padding(bottom = 55.dp)
    ) {
        item {
            Text(
                text = "Formularios pendientes",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "La cantidad de formularios pendientes son: $formularioCount",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
        items(items = formulario) { formulario ->
            ClientPendienteItem(navController = navController, formulario = formulario)
        }
    }
}









