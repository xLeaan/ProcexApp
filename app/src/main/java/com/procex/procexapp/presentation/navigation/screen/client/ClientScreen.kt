package com.procex.procexapp.presentation.navigation.screen.client

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ClientScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
    ){

    object Formulario: ClientScreen(
        route = "client/formulario/update",
        title = "Formulario",
        icon = Icons.Default.List
    )
    object Info: ClientScreen(
        route = "client/informacion",
        title = "Información",
        icon = Icons.Default.Info
    )
    object Perfil: ClientScreen(
        route = "client/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )



}
