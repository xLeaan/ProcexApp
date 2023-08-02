package com.procex.procexapp.data.dataSource.local

import com.procex.procexapp.data.dataSource.local.entity.FormularioEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface FormularioLocalDataSource {

    suspend fun create(formulario: FormularioEntity)
    suspend fun insertAll(formulario: List<FormularioEntity>)
    fun getFormulario(): Flow<List<FormularioEntity>>
    suspend fun update(
        id: String,
        consulta: String,
        name_med: String,
        name: String,
        tipo_documento: String,
        num_documento: String,
        sexo: String,
        fecha: String,
        telefono: String,
        antecedentes_medicos: String,
        RH: String,
        historial_familiar: String,
        medicamentos_ac: String,
        historial_vacunas: String,
        nota_uno: String,
        nota_dos: String? = null,
        seguro: String,
        image: String)
    suspend fun delete(id: String)

}