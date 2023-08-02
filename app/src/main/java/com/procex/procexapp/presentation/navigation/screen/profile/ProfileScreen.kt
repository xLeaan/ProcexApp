package com.procex.procexapp.presentation.navigation.screen.profile

sealed class ProfileScreen(val route: String){

    object ProfileUpdate: ProfileScreen("perfil/update")

}
