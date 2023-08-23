    package com.procex.procexapp.presentation.screens.client.resumen.components



import android.util.Log
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.presentation.screens.client.list.ClientFormularioListViewModel
import com.procex.procexapp.presentation.screens.client.list.components.ClientFormularioListItem
import com.procex.procexapp.presentation.screens.client.resumen.ClientFormularioResumenViewModel

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

        Log.d("Get formulario", "Data: ${ formulario }")

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
                .padding(bottom = 55.dp)
        ) {
            item {
                Text(
                    text = "La cantidad de pacientes masculinos son: $countFormulariosM",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp)
                )
                Text(
                    text = "La cantidad de pacientes femeninos son: $countFormulariosF",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp)
                )
                Text(
                    text = "Cantidad de formularios del mes de Julio: $countFormulariosM1",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp)
                )
                Text(
                    text = "Cantidad de formularios del mes de Agosto: $countFormulariosM2",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }

        }
    }





