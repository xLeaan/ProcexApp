package com.procex.procexapp.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.procex.procexapp.presentation.navigation.Graph
import com.procex.procexapp.presentation.navigation.graph.profile.ProfileNavGraph
import com.procex.procexapp.presentation.screens.client.list.ClientFormularioListScreen
import com.procex.procexapp.presentation.navigation.screen.client.ClientScreen
import com.procex.procexapp.presentation.screens.client.info.InfoScreen
import com.procex.procexapp.presentation.screens.profile.info.ProfileScreen

@Composable
fun ClientNavGraph(navController: NavHostController){
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
        composable(route = ClientScreen.Perfil.route){
            ProfileScreen(navController)
        }

        ProfileNavGraph(navController)
        ClientFormularioNavGraph(navController)

    }
}
