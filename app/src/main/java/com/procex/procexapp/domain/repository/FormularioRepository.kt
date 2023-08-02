package com.procex.procexapp.domain.repository

import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import java.io.File

interface FormularioRepository {

    suspend fun create(formulario: Formulario, file: File): Resource<Formulario>
    fun getFormulario(): Flow<Resource<List<Formulario>>>
    fun findByNum(num_documento: String): Flow<Resource<List<Formulario>>>
    fun findByType(tipo_documento: String): Flow<Resource<List<Formulario>>>
    fun findByTypeAndNum(tipo_documento: String, num_documento: String): Flow<Resource<List<Formulario>>>
    suspend fun update(id: String, formulario: Formulario): Resource<Formulario>
    suspend fun updateWithImage(id: String, formulario: Formulario, file: File): Resource<Formulario>
    suspend fun delete(id: String): Resource<Unit>

}