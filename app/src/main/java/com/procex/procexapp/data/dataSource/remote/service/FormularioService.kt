package com.procex.procexapp.data.dataSource.remote.service

import com.procex.procexapp.domain.model.Formulario
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface FormularioService {

    @GET("formulario")
    suspend fun getFormulario(): Response<List<Formulario>>

    @GET("formulario/search/{num_documento}")
    suspend fun findByNum(
        @Path("num_documento") num_documento: String
    ): Response<List<Formulario>>

    @GET("formulario/searcht/{tipo_documento}")
    suspend fun findByType(
        @Path("tipo_documento") tipo_documento: String
    ): Response<List<Formulario>>

    @GET("formulario/searcha/{tipo_documento}/{num_documento}")
    suspend fun findByTypeAndNum(
        @Path("tipo_documento") tipo_documento: String,
        @Path("num_documento") num_documento: String
    ): Response<List<Formulario>>

    @GET("formulario/searchf")
    suspend fun findBySexoF(): Response<List<Formulario>>

    @GET("formulario/searchm")
    suspend fun findBySexoM(): Response<List<Formulario>>

    @GET("formulario/searchm1")
    suspend fun findByMes1(): Response<List<Formulario>>

    @GET("formulario/searchm2")
    suspend fun findByMes2(): Response<List<Formulario>>

    @Multipart
    @POST("formulario")
    suspend fun create(
        @Part file: MultipartBody.Part,
        @Part("consulta") consulta: RequestBody,
        @Part("name_med") name_med: RequestBody,
        @Part("name") name: RequestBody,
        @Part("tipo_documento") tipo_documento: RequestBody,
        @Part("num_documento") num_documento: RequestBody,
        @Part("sexo") sexo: RequestBody,
        @Part("RH") RH: RequestBody,
        @Part("fecha") fecha: RequestBody,
        @Part("telefono") telefono: RequestBody,
        @Part("tipo_visita") tipo_visita: RequestBody,
        @Part("cl_visita") cl_visita: RequestBody,
        @Part("causa") causa: RequestBody,
        @Part("direccion") direccion: RequestBody,
        @Part("barrio") barrio: RequestBody,
        @Part("propiedad") propiedad: RequestBody,
        @Part("tensiona") tensiona: RequestBody,
        @Part("tipo_ta") tipo_ta: RequestBody,
        @Part("toma_ta") toma_ta: RequestBody,
        @Part("resultado_ta") resultado_ta: RequestBody,
        @Part("oximetria") oximetria: RequestBody,
        @Part("toma_oxi") toma_oxi: RequestBody,
        @Part("resultado_oxi") resultado_oxi: RequestBody,
        @Part("findrisk") findrisk: RequestBody,
        @Part("estatura") estatura: RequestBody,
        @Part("peso") peso: RequestBody,
        @Part("nota_uno") nota_uno: RequestBody,
    ): Response<Formulario>

    @PUT("formulario/{id}")
    suspend fun update(
        @Path("id") id: String,
        @Body formulario: Formulario
    ): Response<Formulario>

    @Multipart
    @PUT("formulario/upload/{id}")
    suspend fun updateWithImage(
        @Part file: MultipartBody.Part,
        @Path("id") id: String,
        @Part("consulta") consulta: RequestBody,
        @Part("name_med") name_med: RequestBody,
        @Part("name") name: RequestBody,
        @Part("tipo_documento") tipo_documento: RequestBody,
        @Part("num_documento") num_documento: RequestBody,
        @Part("sexo") sexo: RequestBody,
        @Part("RH") RH: RequestBody,
        @Part("fecha")fecha: RequestBody,
        @Part("telefono") telefono: RequestBody,
        @Part("tipo_visita") tipo_visita: RequestBody,
        @Part("cl_visita") cl_visita: RequestBody,
        @Part("causa") causa: RequestBody,
        @Part("direccion") direccion: RequestBody,
        @Part("barrio") barrio: RequestBody,
        @Part("propiedad") propiedad: RequestBody,
        @Part("tensiona") tensiona: RequestBody,
        @Part("tipo_ta") tipo_ta: RequestBody,
        @Part("toma_ta") toma_ta: RequestBody,
        @Part("resultado_ta") resultado_ta: RequestBody,
        @Part("oximetria") oximetria: RequestBody,
        @Part("toma_oxi") toma_oxi: RequestBody,
        @Part("resultado_oxi") resultado_oxi: RequestBody,
        @Part("findrisk") findrisk: RequestBody,
        @Part("estatura") estatura: RequestBody,
        @Part("peso") peso: RequestBody,
        @Part("nota_uno") nota_uno: RequestBody,
    ): Response<Formulario>

    @DELETE("formulario/{id}")
    suspend fun delete(
        @Path("id") id: String,
    ): Response<Unit>



}