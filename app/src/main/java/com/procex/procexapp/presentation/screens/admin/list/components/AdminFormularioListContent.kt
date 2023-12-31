package com.procex.procexapp.presentation.screens.admin.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.procex.procexapp.domain.model.Formulario

@Composable
fun AdminFormularioListContent(navController: NavHostController, formulario: List<Formulario>, paddingValues: PaddingValues){

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
            .padding(bottom = 55.dp)
    ){
        val formularioCount = formulario.size
        item {
        Text(
            text = "La cantidad de formularios son: $formularioCount",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
        items(
            items = formulario
        ){formulario ->
            AdminFormularioListItem(navController, formulario)
        }
    }

}