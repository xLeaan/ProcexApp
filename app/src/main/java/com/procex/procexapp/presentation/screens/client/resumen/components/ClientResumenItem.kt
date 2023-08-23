package com.procex.procexapp.presentation.screens.client.resumen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.procex.procexapp.domain.model.Formulario

@Composable
fun ClientResumenItem(formulario: Formulario){
    
    Column(
        Modifier.padding(start = 20.dp, end = 20.dp, top = 15.dp)
    ) {

                Column {
                    Text(
                        text = formulario.name,
                        color = Color.Black,
                        fontSize = 17.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = formulario.sexo,
                        color = Color.Gray,
                        fontSize = 14.sp
                    )

                }
        Divider(
            color = Color.LightGray,
            startIndent = 30.dp
        )
    }


}