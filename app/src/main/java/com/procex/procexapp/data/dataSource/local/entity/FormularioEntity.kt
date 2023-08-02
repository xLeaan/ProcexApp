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
    @ColumnInfo(name = "consulta") var consulta: String = "",
    @ColumnInfo(name = "name_med") var name_med: String = "",
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "tipo_documento") var tipo_documento: String = "",
    @ColumnInfo(name = "num_documento") var num_documento: String = "",
    @ColumnInfo(name = "sexo") var sexo: String = "",
    @ColumnInfo(name = "fecha") var fecha: String = "",
    @ColumnInfo(name = "telefono") var telefono: String = "",
    @ColumnInfo(name = "antecedentes_medicos") var antecedentes_medicos: String = "",
    @ColumnInfo(name = "RH") var RH: String = "",
    @ColumnInfo(name = "historial_familiar") var historial_familiar: String = "",
    @ColumnInfo(name = "medicamentos_ac") var medicamentos_ac: String = "",
    @ColumnInfo(name = "historial_vacunas") var historial_vacunas: String = "",
    @ColumnInfo(name = "nota_uno") var nota_uno: String = "",
    @ColumnInfo(name = "nota_dos") var nota_dos: String? = null,
    @ColumnInfo(name = "seguro") var seguro: String = "",
    @ColumnInfo(name = "image") var image: String = "",
)
