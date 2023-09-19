package com.procex.procexapp.presentation.navigation.screen.client

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Face
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
        route = "client/formulario",
        title = "Form.",
        icon = Icons.Default.List
    )
    object Info: ClientScreen(
        route = "client/info",
        title = "Info.",
        icon = Icons.Default.Info
    )
    object Resumen: ClientScreen(
        route = "client/resumen",
        title = "Resumen",
        icon = Icons.Default.Face
    )
    object Perfil: ClientScreen(
        route = "client/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )

}
