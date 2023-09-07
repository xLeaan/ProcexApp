package com.procex.procexapp.presentation.navigation.screen.client

sealed class PendienteScreen(val route: String){

    object PendienteUpdate: PendienteScreen("perfil/pendiente")

}