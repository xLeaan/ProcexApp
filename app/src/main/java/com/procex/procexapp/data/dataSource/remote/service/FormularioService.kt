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
        @Part("fecha") fecha: RequestBody,
        @Part("telefono") telefono: RequestBody,
        @Part("antecedentes_medicos") antecedentes_medicos: RequestBody,
        @Part("RH") RH: RequestBody,
        @Part("historial_familiar") historial_familiar: RequestBody,
        @Part("medicamentos_ac") medicamentos_ac: RequestBody,
        @Part("historial_vacunas") hisotorial_vacunas: RequestBody,
        @Part("nota_uno") nota_uno: RequestBody,
        @Part("nota_dos") nota_dos: RequestBody? = null,
        @Part("seguro") seguro: RequestBody,
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
        @Part("fecha")fecha: RequestBody,
        @Part("telefono") telefono: RequestBody,
        @Part("antecedentes_medicos") antecedentes_medicos: RequestBody,
        @Part("RH") RH: RequestBody,
        @Part("historial_familiar") historial_familiar: RequestBody,
        @Part("medicamentos_ac") medicamentos_ac: RequestBody,
        @Part("historial_vacunas") hisotorial_vacunas: RequestBody,
        @Part("nota_uno") nota_uno: RequestBody,
        @Part("nota_dos") nota_dos: RequestBody? = null,
        @Part("seguro") seguro: RequestBody,
    ): Response<Formulario>

    @DELETE("formulario/{id}")
    suspend fun delete(
        @Path("id") id: String,
    ): Response<Unit>



}