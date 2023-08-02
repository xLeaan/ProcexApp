package com.procex.procexapp.presentation.screens.client.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.procex.procexapp.domain.model.Formulario

@Composable
fun ClientFormularioListContent(
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
                text = "La cantidad de formularios son: $formularioCount",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
        items(items = formulario) { formulario ->
            ClientFormularioListItem(navController = navController, formulario = formulario)
        }
    }
}

