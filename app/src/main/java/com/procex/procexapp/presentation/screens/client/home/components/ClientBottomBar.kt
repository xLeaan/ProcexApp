package com.procex.procexapp.presentation.screens.client.home.components

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.procex.procexapp.presentation.navigation.screen.client.ClientScreen

@Composable
fun ClientBottomBar(navController: NavHostController){
    val screens = listOf(
        ClientScreen.Formulario,
        ClientScreen.Info,
        ClientScreen.Resumen,
        ClientScreen.Perfil
    )

    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination){
        BottomNavigation(){
            screens.forEach{ screen ->
                ClientBottomBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}