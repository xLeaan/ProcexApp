package com.procex.procexapp.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class User(
    @SerializedName("id")  val id: String? = null,
    @SerializedName("name") var name: String,
    @SerializedName("lastname") var lastname: String,
    @SerializedName("email") val email: String? = null,
    @SerializedName("phone") var phone: String,
    @SerializedName("password") val password: String? = null,
    @SerializedName("img") var img: String? = null,
    @SerializedName("notification_token") val notificationToken: String? = null,
    @SerializedName("roles") val roles: List<Rol>? = null,
){

    fun toJson(): String = Gson().toJson(User(
        id,
        name,
        lastname,
        email,
        phone,
        password,
        if (!img.isNullOrBlank()) URLEncoder.encode(img, StandardCharsets.UTF_8.toString()) else "",
        notificationToken,
        roles?.map { rol -> Rol.fromJson(rol.toJson()) }
    ))

    companion object{
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }

}
