package com.procex.procexapp.presentation.screens.auth.register.mapper

import com.procex.procexapp.domain.model.User
import com.procex.procexapp.presentation.screens.auth.register.RegisterState

fun RegisterState.toUser(): User{
    return User(
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        password = password
    )
}