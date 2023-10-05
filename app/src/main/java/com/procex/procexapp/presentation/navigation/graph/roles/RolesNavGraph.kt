package com.procex.procexapp.presentation.navigation.graph.roles

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.procex.procexapp.presentation.navigation.Graph
import com.procex.procexapp.presentation.navigation.screen.roles.RolesScreen
import com.procex.procexapp.presentation.screens.admin.home.AdminHomeScreen
import com.procex.procexapp.presentation.screens.client.home.ClientHomeScreen
import com.procex.procexapp.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.RolesNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ROLES,
        startDestination = RolesScreen.Roles.route
    ){
        composable(route = RolesScreen.Roles.route){
            RolesScreen(navController)
        }
        composable(route = Graph.CLIENT){
            ClientHomeScreen()
        }
        composable(route = Graph.ADMIN){
            AdminHomeScreen()
        }
    }
}