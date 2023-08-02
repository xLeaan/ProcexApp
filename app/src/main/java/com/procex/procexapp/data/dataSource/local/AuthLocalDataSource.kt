package com.procex.procexapp.data.dataSource.local

import com.procex.procexapp.domain.model.AuthResponse
import com.procex.procexapp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {

    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>

}