package com.procex.procexapp.presentation.screens.client.resumen.components


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.presentation.screens.client.list.components.ClientFormularioListItem
import com.procex.procexapp.presentation.screens.client.pendientes.components.ClientPendienteItem
import com.procex.procexapp.presentation.screens.client.resumen.ClientFormularioPendienteViewModel
import com.procex.procexapp.presentation.ui.Blue200
import com.procex.procexapp.presentation.ui.Pink80

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
                text = "La cantidad de formularios pendietes son: $formularioCount",
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









