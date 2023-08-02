package com.procex.procexapp.domain.repository

import com.procex.procexapp.domain.model.AuthResponse
import com.procex.procexapp.domain.model.User
import com.procex.procexapp.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun login(email: String, password: String): Resource<AuthResponse>
    suspend fun register(user: User): Resource<AuthResponse>
    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>

}