package com.procex.procexapp.presentation.screens.profile.update.mapper

import com.procex.procexapp.domain.model.User
import com.procex.procexapp.presentation.screens.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        img = img
    )
}