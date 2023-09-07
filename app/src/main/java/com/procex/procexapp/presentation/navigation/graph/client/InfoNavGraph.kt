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
import com.procex.procexapp.presentation.screens.client.formulario.create.ClientFormularioCreateScreen
import com.procex.procexapp.presentation.screens.profile.update.ProfileUpdateScreen

fun NavGraphBuilder.InfoNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.INFO,
        startDestination = ClientFormularioScreen.FormularioPendiente.route
    ) {
        composable(route = ClientFormularioScreen.FormularioPendiente.route){
            ClientFormularioCreateScreen(navController)
        }
        composable(
            route = InfoScreen.InfoUpdate.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
        }
    }
}