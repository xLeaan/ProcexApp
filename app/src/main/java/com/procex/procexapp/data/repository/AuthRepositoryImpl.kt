package com.procex.procexapp.data.repository

import com.procex.procexapp.data.dataSource.local.AuthLocalDataSource
import com.procex.procexapp.data.dataSource.remote.AuthRemoteDataSource
import com.procex.procexapp.domain.model.AuthResponse
import com.procex.procexapp.domain.model.User
import com.procex.procexapp.domain.repository.AuthRepository
import com.procex.procexapp.domain.util.Resource
import com.procex.procexapp.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource

    ): AuthRepository {

    override suspend fun login(email: String, password: String): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.login(email,password))

    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)
    override suspend fun updateSession(user: User) = authLocalDataSource.updateSession(user)

    override suspend fun logout() = authLocalDataSource.logout()

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()

}