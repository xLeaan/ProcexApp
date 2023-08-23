package com.procex.procexapp.data.dataSource.remote

import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import java.io.File

interface FormularioRemoteDataSource {

    suspend fun create(formulario: Formulario, file: File): Response<Formulario>
    suspend fun getFormulario(): Response<List<Formulario>>
    suspend fun findByNum(num_documento: String): Response<List<Formulario>>
    suspend fun findByType(tipo_documento: String): Response<List<Formulario>>
    suspend fun findByTypeAndNum(tipo_documento: String, num_documento: String): Response<List<Formulario>>
    suspend fun findBySexoF(sexo: String): Response<List<Formulario>>
    suspend fun findBySexoM(sexo: String): Response<List<Formulario>>
    suspend fun findByMes1(created_at: String): Response<List<Formulario>>
    suspend fun findByMes2(created_at: String): Response<List<Formulario>>
    suspend fun update(id: String, formulario: Formulario): Response<Formulario>
    suspend fun updateWithImage(id: String, formulario: Formulario, file: File): Response<Formulario>
    suspend fun delete(id: String): Response<Unit>

}