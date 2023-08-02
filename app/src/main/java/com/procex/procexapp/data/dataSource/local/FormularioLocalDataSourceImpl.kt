package com.procex.procexapp.data.dataSource.local

import com.procex.procexapp.data.dataSource.local.dao.FormularioDao
import com.procex.procexapp.data.dataSource.local.entity.FormularioEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

class FormularioLocalDataSourceImpl(private val formularioDao: FormularioDao): FormularioLocalDataSource {

    override suspend fun create(formulario: FormularioEntity) = formularioDao.insert(formulario)

    override suspend fun insertAll(formulario: List<FormularioEntity>) = formularioDao.insertAll(formulario)

    override fun getFormulario(): Flow<List<FormularioEntity>> = formularioDao.getFormulario()


    override suspend fun update(
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
        nota_dos: String?,
        seguro: String,
        image: String

    ) = formularioDao.update(id, consulta, name_med, name, tipo_documento, num_documento, sexo, fecha, telefono, antecedentes_medicos, RH,
        historial_familiar, medicamentos_ac, historial_vacunas, nota_uno,
        nota_dos, seguro, image)

    override suspend fun delete(id: String) = formularioDao.delete(id)


}