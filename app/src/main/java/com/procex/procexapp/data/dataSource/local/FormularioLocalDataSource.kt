package com.procex.procexapp.data.dataSource.local

import androidx.lifecycle.LiveData
import com.procex.procexapp.data.dataSource.local.entity.FormularioEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface FormularioLocalDataSource {

    suspend fun create(formulario: FormularioEntity)
    suspend fun insertAll(formulario: List<FormularioEntity>)
    fun getFormulario(): Flow<List<FormularioEntity>>

    fun getFormularioByNum(num_documento: String): LiveData<FormularioEntity>
    fun getFormularioByType(tipo_documento: String): Flow<List<FormularioEntity>>
    fun getFormularioByTypeAndNum(tipo_documento: String, numero_documento: String): LiveData<FormularioEntity>
    suspend fun update(
        id: String,
        consulta: String,
        name_med: String,
        name: String,
        tipo_documento: String,
        num_documento: String,
        sexo: String,
        RH: String,
        fecha: String,
        telefono: String,
        tipo_visita: String,
        cl_visita: String,
        causa: String,
        direccion: String,
        barrio: String,
        propiedad: String,
        tensiona: String,
        tipo_ta: String,
        toma_ta: String,
        resultado_ta: String,
        oximetria: String,
        toma_oxi: String,
        resultado_oxi: String ,
        findrisk: String,
        estatura: String,
        peso: String,
        nota_uno: String,
        image: String)
    suspend fun delete(id: String)

}