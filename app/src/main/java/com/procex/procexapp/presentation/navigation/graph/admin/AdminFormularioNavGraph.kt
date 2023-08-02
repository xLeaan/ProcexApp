package com.procex.procexapp.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.procex.procexapp.presentation.screens.admin.formulario.create.AdminFormularioCreateScreen
import com.procex.procexapp.presentation.screens.admin.formulario.update.AdminFormularioUpdateScreen
import com.procex.procexapp.presentation.navigation.Graph
import com.procex.procexapp.presentation.navigation.screen.admin.AdminFormularioScreen

fun NavGraphBuilder.AdminFormularioNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ADMIN_FORMULARIO,
        startDestination = AdminFormularioScreen.FormularioCreate.route
    ){
        composable(route = AdminFormularioScreen.FormularioCreate.route){
            AdminFormularioCreateScreen(navController)
        }

        composable(
            route = AdminFormularioScreen.FormularioUpdate.route,
            arguments = listOf(navArgument("formulario"){
                type = NavType.StringType
            })
            ){
            it.arguments?.getString("formulario")?.let {
                AdminFormularioUpdateScreen(navController, it) }
        }

    }
}