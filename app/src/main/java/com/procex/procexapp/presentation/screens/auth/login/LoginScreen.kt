@file:OptIn(ExperimentalMaterial3Api::class)

package com.procex.procexapp.presentation.screens.auth.login

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.procex.procexapp.presentation.screens.auth.login.components.Login
import com.procex.procexapp.presentation.screens.auth.login.components.LoginContent
import com.procex.procexapp.presentation.ui.ProcexAppTheme

@Composable
fun LoginScreen(navController: NavHostController){
    Scaffold(
        
    ) { paddingValues ->
        LoginContent(navController = navController, paddingValues)
    }
    Login(navController = navController)
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    ProcexAppTheme {
        LoginScreen(rememberNavController())
    }
}