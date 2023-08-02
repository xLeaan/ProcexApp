package com.procex.procexapp.presentation.navigation.graph.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.procex.procexapp.presentation.screens.admin.list.AdminFormularioListScreen
import com.procex.procexapp.presentation.navigation.Graph
import com.procex.procexapp.presentation.navigation.graph.profile.ProfileNavGraph
import com.procex.procexapp.presentation.navigation.screen.admin.AdminScreen
import com.procex.procexapp.presentation.screens.profile.info.ProfileScreen


@Composable
fun AdminNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.Formulario.route
    ){
        composable(route = AdminScreen.Formulario.route){
            AdminFormularioListScreen(navController)
        }
        composable(route = AdminScreen.Perfil.route){
            ProfileScreen(navController)
        }
        ProfileNavGraph(navController)
        AdminFormularioNavGraph(navController)

    }
}