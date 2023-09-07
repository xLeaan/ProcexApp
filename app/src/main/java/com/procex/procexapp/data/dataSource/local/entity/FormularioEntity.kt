package com.procex.procexapp.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.procex.procexapp.domain.model.Formulario
import java.util.Date

@Entity(tableName = "formulario")
data class FormularioEntity(
    @PrimaryKey var id: String = "",
    @ColumnInfo(name = "estado") var estado: String = "",
    @ColumnInfo(name = "name_med") var name_med: String = "",
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "tipo_documento") var tipo_documento: String = "",
    @ColumnInfo(name = "num_documento") var num_documento: String = "",
    @ColumnInfo(name = "sexo") var sexo: String = "",
    @ColumnInfo(name = "RH") var RH: String = "",
    @ColumnInfo(name = "fecha") var fecha: String = "",
    @ColumnInfo(name = "telefono") var telefono: String = "",
    @ColumnInfo(name = "tipo_visita")var tipo_visita: String = "",
    @ColumnInfo(name = "cl_visita")var cl_visita: String = "",
    @ColumnInfo(name = "causa")var causa: String = "",
    @ColumnInfo(name = "direccion")var direccion: String = "",
    @ColumnInfo(name = "barrio")var barrio: String = "",
    @ColumnInfo(name = "propiedad")var propiedad: String = "",
    @ColumnInfo(name = "tensiona")var tensiona: String = "",
    @ColumnInfo(name = "tipo_ta")var tipo_ta: String = "",
    @ColumnInfo(name = "toma_ta")var toma_ta: String = "",
    @ColumnInfo(name = "resultado_ta")var resultado_ta: String = "",
    @ColumnInfo(name = "oximetria")var oximetria: String = "",
    @ColumnInfo(name = "toma_oxi")var toma_oxi: String = "",
    @ColumnInfo(name = "resultado_oxi")var resultado_oxi: String = "",
    @ColumnInfo(name = "findrisk")var findrisk: String = "",
    @ColumnInfo(name = "estatura")var estatura: String = "",
    @ColumnInfo(name = "peso")var peso: String = "",
    @ColumnInfo(name = "nota_uno")val nota_uno: String = "",
    @ColumnInfo(name = "image")val image: String = ""
)
