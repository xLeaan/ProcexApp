package com.procex.procexapp.data.repository

import com.procex.procexapp.data.dataSource.remote.UsersRemoteDataSource
import com.procex.procexapp.domain.model.User
import com.procex.procexapp.domain.repository.UsersRepository
import com.procex.procexapp.domain.util.Resource
import com.procex.procexapp.domain.util.ResponseToRequest
import java.io.File

class UsersRepositoryImpl(
    private val usersRemoteDataSource: UsersRemoteDataSource,

    ): UsersRepository {

    override suspend fun update(id: String, user: User): Resource<User> = ResponseToRequest.send(
        usersRemoteDataSource.update(id, user)
    )

    override suspend fun updateWithImage(id: String, user: User, file: File): Resource<User> = ResponseToRequest.send(
        usersRemoteDataSource.updateWithImage(id, user, file)
    )

}