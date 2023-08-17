package com.procex.procexapp.presentation.navigation.screen.client

sealed class ResumenScreen(val route: String){

    object ResumenUpdate: ResumenScreen("perfil/resumen")

}