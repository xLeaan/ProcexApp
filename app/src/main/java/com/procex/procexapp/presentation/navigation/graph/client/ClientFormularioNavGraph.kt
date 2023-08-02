package com.procex.procexapp.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.procex.procexapp.presentation.navigation.Graph
import com.procex.procexapp.presentation.navigation.screen.admin.AdminFormularioScreen
import com.procex.procexapp.presentation.navigation.screen.client.ClientFormularioScreen
import com.procex.procexapp.presentation.screens.client.formulario.create.ClientFormularioCreateScreen
import com.procex.procexapp.presentation.screens.client.formulario.update.ClientFormularioUpdateScreen

fun NavGraphBuilder.ClientFormularioNavGraph(navController: NavHostController){
    navigation(
        route = Graph.CLIENT_FORMULARIO,
        startDestination = ClientFormularioScreen.FormularioCreate.route
    ){
        composable(route = ClientFormularioScreen.FormularioCreate.route){
            ClientFormularioCreateScreen(navController)
        }

        composable(route = ClientFormularioScreen.FormularioUpdate.route,
            arguments = listOf(navArgument("formulario"){
                type = NavType.StringType
            })
            ){
            it.arguments?.getString("formulario")?.let {
                ClientFormularioUpdateScreen(navController, it) }
        }

    }
}
