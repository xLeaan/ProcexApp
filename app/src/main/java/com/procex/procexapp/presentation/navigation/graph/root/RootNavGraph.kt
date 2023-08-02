package com.procex.procexapp.presentation.navigation.graph.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.procex.procexapp.presentation.navigation.Graph
import com.procex.procexapp.presentation.navigation.graph.auth.AuthNavGraph
import com.procex.procexapp.presentation.navigation.graph.roles.RolesNavGraph


@Composable
fun RootNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ){
        AuthNavGraph(navController = navController)
        RolesNavGraph(navController = navController)
    }
}