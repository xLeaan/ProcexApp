package com.procex.procexapp.data.dataSource.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.procex.procexapp.data.dataSource.local.entity.FormularioEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date


@Dao
interface FormularioDao {
    //INSERT INTO formulario VALUES
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(formulario: FormularioEntity)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(formulario: List<FormularioEntity>)
    
    @Query("SELECT * FROM formulario")
    fun getFormulario(): Flow<List<FormularioEntity>>

    @Query("SELECT * FROM formulario WHERE num_documento = :num_documento")
    fun getFormularioByNum(num_documento: String): LiveData<FormularioEntity>

    @Query("SELECT * FROM formulario WHERE tipo_documento = :tipo_documento")
    fun getFormularioByType(tipo_documento: String): Flow<List<FormularioEntity>>

    @Query("SELECT * FROM formulario WHERE tipo_documento = :tipo_documento AND num_documento = :numero_documento")
    fun getFormularioByTypeAndNum(tipo_documento: String, numero_documento: String): LiveData<FormularioEntity>

    @Query("UPDATE formulario SET consulta = :consulta, name_med = :name_med, name = :name, tipo_documento = :tipo_documento, num_documento = :num_documento, sexo = :sexo , fecha = :fecha, telefono = :telefono, " +
            "antecedentes_medicos = :antecedentes_medicos, RH = :RH, historial_familiar = :historial_familiar, medicamentos_ac = " +
            ":medicamentos_ac, historial_vacunas = :historial_vacunas, nota_uno = :nota_uno, nota_dos = :nota_dos, seguro = :seguro, image = :image WHERE id = :id")

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
        nota_dos: String ? = "",
        seguro: String,
        image: String)
    
    @Query("DELETE FROM formulario WHERE id = :id")
    suspend fun delete(id: String)

}