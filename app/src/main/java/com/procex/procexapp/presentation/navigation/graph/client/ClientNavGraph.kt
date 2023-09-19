package com.procex.procexapp.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.presentation.navigation.Graph
import com.procex.procexapp.presentation.navigation.graph.profile.ProfileNavGraph
import com.procex.procexapp.presentation.screens.client.list.ClientFormularioListScreen
import com.procex.procexapp.presentation.navigation.screen.client.ClientScreen
import com.procex.procexapp.presentation.screens.client.info.InfoScreen
import com.procex.procexapp.presentation.screens.client.listo.ListoScreen
import com.procex.procexapp.presentation.screens.client.pendientes.PendienteScreen
import com.procex.procexapp.presentation.screens.client.resumen.ResumenScreen
import com.procex.procexapp.presentation.screens.profile.info.ProfileScreen

@Composable
fun ClientNavGraph(navController: NavHostController){
    val sexoList = remember { mutableListOf<Formulario>() }
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.Formulario.route
    ){
        composable(route = ClientScreen.Formulario.route){
            ClientFormularioListScreen(navController)
        }
        composable(route = ClientScreen.Info.route){
            InfoScreen(navController)
        }
        composable(route = ClientScreen.Resumen.route){
            ResumenScreen(navController, sexoList)
        }
        composable(route = ClientScreen.Perfil.route){
            ProfileScreen(navController)
        }
        PendienteNavGraph(navController)
        ClientFormularioNavGraph(navController)
        ResumenNavGraph(navController)
        InfoNavGraph(navController)
        ListoNavGraph(navController)
        ProfileNavGraph(navController)
    }
}
