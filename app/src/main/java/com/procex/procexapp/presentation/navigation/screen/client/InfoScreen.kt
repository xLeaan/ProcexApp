package com.procex.procexapp.presentation.navigation.screen.client

sealed class InfoScreen(val route: String){

    object InfoUpdate: InfoScreen("perfil/info")

}