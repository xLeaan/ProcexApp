package com.procex.procexapp.data.dataSource.remote

import com.procex.procexapp.domain.model.AuthResponse
import com.procex.procexapp.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(documento: String, password: String): Response<AuthResponse>

    suspend fun register(user: User): Response<AuthResponse>

}