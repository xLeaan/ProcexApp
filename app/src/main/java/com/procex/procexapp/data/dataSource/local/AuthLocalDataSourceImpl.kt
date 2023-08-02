package com.procex.procexapp.data.dataSource.local

import com.procex.procexapp.data.dataSource.local.datastore.AuthDatastore
import com.procex.procexapp.data.dataSource.local.AuthLocalDataSource
import com.procex.procexapp.domain.model.AuthResponse
import com.procex.procexapp.domain.model.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDatastore: AuthDatastore):
    AuthLocalDataSource {

    override suspend fun saveSession(authResponse: AuthResponse) = authDatastore.saveUser(authResponse)
    override suspend fun updateSession(user: User) = authDatastore.update(user)
    override suspend fun logout() = authDatastore.delete()
    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()

}