package com.procex.procexapp.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.procex.procexapp.presentation.navigation.Graph
import com.procex.procexapp.presentation.navigation.screen.client.InfoScreen
import com.procex.procexapp.presentation.navigation.screen.client.ResumenScreen
import com.procex.procexapp.presentation.screens.profile.update.ProfileUpdateScreen

fun NavGraphBuilder.ResumenNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.RESUMEN,
        startDestination = ResumenScreen.ResumenUpdate.route
    ) {
        composable(
            route = ResumenScreen.ResumenUpdate.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
        }
    }
}