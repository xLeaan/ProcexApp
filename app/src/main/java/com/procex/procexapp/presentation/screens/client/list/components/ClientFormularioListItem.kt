package com.procex.procexapp.presentation.screens.client.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.presentation.navigation.screen.client.ClientFormularioScreen

@Composable
fun ClientFormularioListItem(
    navController: NavHostController,
    formulario: Formulario,
) {

    Spacer(modifier = Modifier.height(15.dp))
    Card(
        modifier = Modifier
            .padding(bottom = 15.dp)
            .clickable {
                navController.navigate(
                    route = ClientFormularioScreen.FormularioUpdate.passFormulario(
                        formulario.toJson()
                    )
                )
            },
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp)
    ) {

        Column {

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                model = formulario.image,
                contentDescription = "",
            )
            Text(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                text = formulario.cl_visita,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            Text(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                text = formulario.name,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Text(text = formulario.tipo_documento)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = formulario.num_documento,
                )
            }

        }

    }

}


