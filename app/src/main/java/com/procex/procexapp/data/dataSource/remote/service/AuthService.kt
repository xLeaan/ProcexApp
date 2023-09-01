package com.procex.procexapp.data.dataSource.remote.service

import com.procex.procexapp.domain.model.AuthResponse
import com.procex.procexapp.domain.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    //http://10.251.210.37:3000/auth/login
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("documento") documento: String,
        @Field("password") password: String,
    ): Response<AuthResponse>


    @POST("auth/register")
    suspend fun register(
        @Body() user: User,
    ): Response<AuthResponse>

}