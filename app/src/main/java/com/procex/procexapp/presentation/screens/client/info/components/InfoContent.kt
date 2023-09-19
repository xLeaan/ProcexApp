package com.procex.procexapp.presentation.screens.client.info.components

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.procex.procexapp.R
import com.procex.procexapp.presentation.MainActivity
import com.procex.procexapp.presentation.components.DefaultButton
import com.procex.procexapp.presentation.navigation.Graph
import com.procex.procexapp.presentation.screens.profile.info.ProfileViewModel
import com.procex.procexapp.presentation.ui.Blue500
import com.procex.procexapp.presentation.ui.Red200

@Composable
fun InfoContent(paddingValues: PaddingValues, vm: ProfileViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .padding(bottom = 55.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.cliente),
            contentDescription = "Imagen fondo de perfil",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(0.6f, 0.6f, 0.6f, 1f)
                }
            )
        )

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo"
            )
            androidx.compose.material3.Text(
                modifier = Modifier.padding(top = 7.dp),
                text = "MEDIOS DE CONTACTO",
                fontWeight = FontWeight.Bold,
                color = Red200,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                backgroundColor = Color.White.copy(alpha = 0.7f)
            ) {
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 10.dp)
                        ) {
                            Text(text = "Sus solicitudes serán atendidas a este correo:")
                            Text(
                                text = "mesadeayuda@procex.co",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 10.dp)
                        ) {
                            Text(text = "Números móviles para soporte via Whatsapp (sólo chat):")
                            Text(
                                text = "300-666-0504 - 301-690-8595",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 10.dp)
                        ) {
                            Text(text = "Línea atención telefónica:")
                            Text(
                                text = "(604) 499 0000",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }

                }
            }

        }
    }
}




