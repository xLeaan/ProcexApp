package com.procex.procexapp.presentation.navigation.screen.client

sealed class ListoScreen(val route: String){

    object ListoUpdate: ListoScreen("perfil/listo")

}