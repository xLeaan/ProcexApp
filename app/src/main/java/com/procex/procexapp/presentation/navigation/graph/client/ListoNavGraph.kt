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
import com.procex.procexapp.presentation.navigation.screen.client.ListoScreen
import com.procex.procexapp.presentation.navigation.screen.client.PendienteScreen
import com.procex.procexapp.presentation.navigation.screen.client.ResumenScreen
import com.procex.procexapp.presentation.screens.client.info.InfoScreen
import com.procex.procexapp.presentation.screens.client.listo.ListoScreen
import com.procex.procexapp.presentation.screens.profile.update.ProfileUpdateScreen

fun NavGraphBuilder.ListoNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.LISTO,
        startDestination = ClientFormularioScreen.Listo.route
    ) {
        composable(route = ClientFormularioScreen.Listo.route){
            ListoScreen(navController)
        }
        composable(
            route = ListoScreen.ListoUpdate.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
        }
    }
}