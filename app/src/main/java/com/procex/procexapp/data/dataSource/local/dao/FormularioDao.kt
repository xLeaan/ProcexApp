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

    @Query("UPDATE formulario SET consulta = :consulta, name_med = :name_med, name = :name, tipo_documento = :tipo_documento, num_documento = :num_documento, sexo = :sexo ,  RH = :RH, fecha = :fecha, telefono = :telefono, " +
            "tipo_visita = :tipo_visita, cl_visita = :cl_visita, causa = :causa, direccion = :direccion, barrio = :barrio, propiedad = :propiedad, tensiona = :tensiona, tipo_ta " +
            " = :tipo_ta, toma_ta = :toma_ta, resultado_ta = :resultado_ta, oximetria = :oximetria, toma_oxi = :toma_oxi, resultado_oxi = :resultado_oxi, findrisk = :findrisk, estatura " +
            " = :estatura, peso = :peso, nota_uno = :nota_uno, image = :image WHERE id = :id")

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
    
    @Query("DELETE FROM formulario WHERE id = :id")
    suspend fun delete(id: String)

}