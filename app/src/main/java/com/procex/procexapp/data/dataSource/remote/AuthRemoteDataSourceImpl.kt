package com.procex.procexapp.data.dataSource.remote

import com.procex.procexapp.data.dataSource.remote.AuthRemoteDataSource
import com.procex.procexapp.data.dataSource.remote.service.AuthService
import com.procex.procexapp.domain.model.AuthResponse
import com.procex.procexapp.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {

        override suspend fun login(documento: String, password: String) = authService.login(documento, password)

        override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)
}
