package com.procex.procexapp.data.dataSource.remote

import com.procex.procexapp.data.dataSource.remote.UsersRemoteDataSource
import com.procex.procexapp.data.dataSource.remote.service.UsersService
import com.procex.procexapp.domain.model.User
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class UsersRemoteDataSourceImpl(private val usersService: UsersService): UsersRemoteDataSource {

        override suspend fun update(id: String, user: User): Response<User> = usersService.update(id, user)
        override suspend fun updateWithImage(id: String, user: User, file: File): Response<User> {

                val connection = file.toURI().toURL().openConnection()
                val mimeType = connection.contentType // tipo del archivo de imagen
                val contentType = "text/plain"
                val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
                val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
                val nameData = user.name.toRequestBody(contentType.toMediaTypeOrNull())
                val lastnameData = user.lastname.toRequestBody(contentType.toMediaTypeOrNull())
                val phoneData = user.phone.toRequestBody(contentType.toMediaTypeOrNull())

                return usersService.updateWithImage(fileFormData, id, nameData, lastnameData, phoneData)

        }
}
