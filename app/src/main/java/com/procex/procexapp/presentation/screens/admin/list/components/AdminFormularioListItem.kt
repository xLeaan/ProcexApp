package com.procex.procexapp.presentation.screens.admin.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.procex.procexapp.R
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.presentation.screens.admin.list.AdminFormularioListViewModel
import com.procex.procexapp.presentation.navigation.screen.admin.AdminFormularioScreen
import com.procex.procexapp.presentation.navigation.screen.client.ClientFormularioScreen

@Composable
fun AdminFormularioListItem(
    navController: NavHostController,
    formulario: Formulario,
    vm: AdminFormularioListViewModel = hiltViewModel()
) {

    Column(
        Modifier
            .padding(start = 20.dp, end = 20.dp, top = 15.dp)
            .height(90.dp)
    ) {
            Row() {
                AsyncImage(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    model = formulario.image,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    Modifier.weight(1f)
                ) {
                    Text(
                        text = formulario.name,
                        color = Color.Black,
                        fontSize = 17.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = formulario.nota_uno,
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(25.dp)
                            .clickable { navController.navigate(route = AdminFormularioScreen.FormularioUpdate.passFormulario(formulario.toJson())) },
                        painter = painterResource(id = R.drawable.edit),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Image(
                        modifier = Modifier
                            .size(25.dp)
                            .clickable { vm.deleteFormulario(formulario.id ?: "")},
                        painter = painterResource(id = R.drawable.trash),
                        contentDescription = ""
                    )

                }

            }
            Spacer(modifier = Modifier.height(30.dp))
            Divider(
                color = Color.LightGray,
                startIndent = 80.dp
            )
        }
}

