package com.procex.procexapp.presentation.screens.auth.register

data class RegisterState(
    val name: String = "",
    val lastname: String = "",
    val email: String = "",
    val documento: String = "",
    val password: String = "",
    val confirmPassword: String = "",
)
