package com.procex.procexapp.domain.repository

import com.procex.procexapp.domain.model.User
import com.procex.procexapp.domain.util.Resource
import java.io.File

interface UsersRepository {

    suspend fun update(id: String, user: User): Resource<User>
    suspend fun updateWithImage(id: String, user: User, file: File): Resource<User>

}