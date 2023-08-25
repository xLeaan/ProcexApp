package com.procex.procexapp.presentation.screens.client.resumen.components


import android.graphics.Color
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.presentation.navigation.screen.client.ClientFormularioScreen
import com.procex.procexapp.presentation.screens.client.resumen.ClientFormularioResumenViewModel
import com.procex.procexapp.presentation.ui.Blue200
import com.procex.procexapp.presentation.ui.Pink80

@Composable
fun ResumenContent(
    paddingValues: PaddingValues,
    formulario: List<Formulario>,
    vm: ClientFormularioResumenViewModel = hiltViewModel()
) {

    val countFormulariosF = vm.countFormulariosF
    val countFormulariosM = vm.countFormulariosM
    val countFormulariosM1 = vm.countFormulariosM1
    val countFormulariosM2 = vm.countFormulariosM2

    //Log.d("Get formulario", "Data: ${ formulario }")
    Column() {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Reporte:",
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
            text = "Cantidad de formularios del mes de Julio: $countFormulariosM1",
            fontWeight = FontWeight.Bold,
            color = androidx.compose.ui.graphics.Color.Gray,
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
                    text = "Total de población por género",
                    fontWeight = FontWeight.Bold,
                    color = androidx.compose.ui.graphics.Color.Black,
                    textAlign = TextAlign.Center
                )

                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .padding(horizontal = 20.dp)
                ) {
                    val total = countFormulariosF + countFormulariosM
                    val porcentajeFemenino = countFormulariosF.toFloat() / total.toFloat()
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
                ){
                    Text(text = "Femenino: $countFormulariosF")
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Masculino: $countFormulariosM",
                    )
                }

            }

        }

    }
}







