package com.procex.procexapp.presentation.screens.profile.update

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.procex.procexapp.presentation.components.DefaultTopBar
import com.procex.procexapp.presentation.screens.profile.update.components.ProfileUpdateContent
import com.procex.procexapp.presentation.screens.profile.update.components.UpdateUser


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileUpdateScreen(navController: NavHostController, userParam: String ) {

    Log.d("ProfileUpdateScreen", "Data: $userParam")

    Scaffold(
        topBar = { DefaultTopBar(
            title = "Actualizar perfil",
            navController = navController,
            upAvailable = true
        )
        }
    ) { paddingValues ->
        ProfileUpdateContent(paddingValues = paddingValues)
    }
    UpdateUser()
}