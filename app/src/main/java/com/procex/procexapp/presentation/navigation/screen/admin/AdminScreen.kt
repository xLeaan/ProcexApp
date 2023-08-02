package com.procex.procexapp.presentation.navigation.screen.admin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
    ){

    object Formulario: AdminScreen(
        route = "admin/formulario/update",
        title = "Formulario",
        icon = Icons.Default.List
    )
    object Perfil: AdminScreen(
        route = "admin/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )

}
