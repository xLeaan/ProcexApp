package com.procex.procexapp.data.dataSource.local

import androidx.lifecycle.LiveData
import com.procex.procexapp.data.dataSource.local.dao.FormularioDao
import com.procex.procexapp.data.dataSource.local.entity.FormularioEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

class FormularioLocalDataSourceImpl(private val formularioDao: FormularioDao): FormularioLocalDataSource {

    override suspend fun create(formulario: FormularioEntity) = formularioDao.insert(formulario)

    override suspend fun insertAll(formulario: List<FormularioEntity>) = formularioDao.insertAll(formulario)

    override fun getFormulario(): Flow<List<FormularioEntity>> = formularioDao.getFormulario()

    override fun getFormularioByNum(num_documento: String): LiveData<FormularioEntity> = formularioDao.getFormularioByNum(num_documento)

    override fun findReady(estado: String): Flow<List<FormularioEntity>> = formularioDao.findReady(estado)

    override fun findNotReady(estado: String): Flow<List<FormularioEntity>> = formularioDao.findNotReady(estado)

    override fun getFormularioByType(tipo_documento: String): Flow<List<FormularioEntity>> = formularioDao.getFormularioByType(tipo_documento)

    override fun getFormularioByTypeAndNum(tipo_documento: String, numero_documento: String): LiveData<FormularioEntity> = formularioDao.getFormularioByTypeAndNum(tipo_documento, numero_documento)
    override suspend fun update(
        id: String,
        estado: String,
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
        resultado_oxi: String,
        findrisk: String,
        estatura: String,
        peso: String,
        nota_uno: String,
        image: String
    ) = formularioDao.update(id, estado, name_med, name, tipo_documento, num_documento, sexo, RH, fecha, telefono, tipo_visita, cl_visita,
        causa, direccion, barrio, propiedad, tensiona, tipo_ta, toma_ta, resultado_ta, oximetria, toma_oxi, resultado_oxi,
        findrisk, estatura, peso, nota_uno, image)



    override suspend fun delete(id: String) = formularioDao.delete(id)


}