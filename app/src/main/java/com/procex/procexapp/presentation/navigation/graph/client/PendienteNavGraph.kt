package com.procex.procexapp.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.procex.procexapp.presentation.navigation.Graph
import com.procex.procexapp.presentation.navigation.screen.client.ClientFormularioScreen
import com.procex.procexapp.presentation.navigation.screen.client.InfoScreen
import com.procex.procexapp.presentation.navigation.screen.client.PendienteScreen
import com.procex.procexapp.presentation.navigation.screen.client.ResumenScreen
import com.procex.procexapp.presentation.screens.client.info.InfoScreen
import com.procex.procexapp.presentation.screens.client.pendientes.PendienteScreen
import com.procex.procexapp.presentation.screens.profile.update.ProfileUpdateScreen

fun NavGraphBuilder.PendienteNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PENDIENTE,
        startDestination = ClientFormularioScreen.Pendiente.route
    ) {
        composable(route = ClientFormularioScreen.Pendiente.route){
           PendienteScreen(navController)
        }
        composable(
            route = PendienteScreen.PendienteUpdate.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
        }
    }
}