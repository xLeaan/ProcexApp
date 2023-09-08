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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.presentation.screens.client.resumen.ClientFormularioResumenViewModel
import com.procex.procexapp.presentation.ui.Blue200
import com.procex.procexapp.presentation.ui.Green10
import com.procex.procexapp.presentation.ui.Green40
import com.procex.procexapp.presentation.ui.Pink80
import com.procex.procexapp.presentation.ui.PurpleGrey40
import com.procex.procexapp.presentation.ui.Red200

@Composable
fun ResumenContent(
    paddingValues: PaddingValues,
    formulario: List<Formulario>,
    vm: ClientFormularioResumenViewModel = hiltViewModel()
) {
    val countVisitasEfectivas = vm.countFormulariosE
    val countVisitasNoEfectivas = vm.countFormulariosNE
    val visitas = countVisitasEfectivas + countVisitasNoEfectivas

    val countFormulariosListos = vm.countFormulariosListos
    val countFormulariosPendientes = vm.countFormulariosPendientes
    val formularios = countFormulariosPendientes + countFormulariosListos

    val formulariosF = vm.countFormulariosF
    val formulariosM = vm.countFormulariosM

    //Log.d("Get formulario", "Data: ${ formulario }")
    Column() {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Reporte:",
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .padding(bottom = 15.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                    text = "Total de visitas: $visitas",
                    fontWeight = FontWeight.Bold,
                    color = androidx.compose.ui.graphics.Color.Black,
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Efectivas: $countVisitasEfectivas")
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "No efectivas: $countVisitasNoEfectivas",
                    )
                }

                // Dibuja las barras gráficas
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .padding(horizontal = 20.dp)
                ) {
                    val total = visitas.toFloat()
                    val porcentajeEfectivas = countVisitasEfectivas.toFloat() / total
                    val anchoEfectivas = size.width * porcentajeEfectivas
                    val anchoNoEfectivas = size.width * (1 - porcentajeEfectivas)

                    drawRect(
                        color = Green10,
                        size = Size(anchoEfectivas, size.height)
                    )

                    drawRect(
                        color = Red200,
                        topLeft = Offset(anchoEfectivas, 0f),
                        size = Size(anchoNoEfectivas, size.height)
                    )
                }
                Text(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                    text = "",
                    fontWeight = FontWeight.Bold,
                    color = androidx.compose.ui.graphics.Color.Black,
                    textAlign = TextAlign.Center
                )

            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Card(
            modifier = Modifier
                .padding(bottom = 15.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                    text = "Informe de géneros",
                    fontWeight = FontWeight.Bold,
                    color = androidx.compose.ui.graphics.Color.Black,
                    textAlign = TextAlign.Center
                )

                // Dibuja las barras gráficas
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .padding(horizontal = 20.dp)
                ) {
                    val total = formulariosF + formulariosM
                    val porcentajeFemenino = formulariosF.toFloat() / total.toFloat()
                    val anchoFemenino = size.width * porcentajeFemenino
                    val anchoMasculino = size.width * (1 - porcentajeFemenino)

                    drawRect(
                        color = Pink80,
                        size = Size(anchoFemenino, size.height)
                    )

                    drawRect(
                        color = Blue200,
                        topLeft = Offset(anchoFemenino, 0f),
                        size = Size(anchoMasculino, size.height)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Femenino: $formulariosF")
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Masculino: $formulariosM",
                    )
                }

            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Card(
            modifier = Modifier
                .padding(bottom = 15.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                    text = "Informe de formularios",
                    fontWeight = FontWeight.Bold,
                    color = androidx.compose.ui.graphics.Color.Black,
                    textAlign = TextAlign.Center
                )

                // Dibuja las barras gráficas
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .padding(horizontal = 20.dp)
                ) {
                    val total = countFormulariosListos + countFormulariosPendientes
                    val porcentajeListos = countFormulariosListos.toFloat() / total.toFloat()
                    val anchoListos = size.width * porcentajeListos
                    val anchoPendientes = size.width * (1 - porcentajeListos)

                    drawRect(
                        color = Green40,
                        size = Size(anchoListos, size.height)
                    )

                    drawRect(
                        color = PurpleGrey40,
                        topLeft = Offset(anchoListos, 0f),
                        size = Size(anchoPendientes, size.height)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Listos: $countFormulariosListos")
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Pendientes: $countFormulariosPendientes",
                    )
                }

            }
        }
    }
}









