package com.procex.procexapp.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.Date

data class Formulario(
    @SerializedName("id") val id: String? = null,
    @SerializedName("consulta") val consulta: String,
    @SerializedName("name_med") val name_med: String,
    @SerializedName("name") val name: String,
    @SerializedName("tipo_documento") val tipo_documento: String,
    @SerializedName("num_documento") val num_documento: String,
    @SerializedName("sexo") val sexo: String,
    @SerializedName("fecha") val fecha: String,
    @SerializedName("telefono") val telefono: String,
    @SerializedName("antecedentes_medicos") val antecedentes_medicos: String,
    @SerializedName("RH") val RH: String,
    @SerializedName("historial_familiar") val historial_familiar: String,
    @SerializedName("medicamentos_ac") val medicamentos_ac: String,
    @SerializedName("historial_vacunas") val historial_vacunas: String,
    @SerializedName("nota_uno") val nota_uno: String,
    @SerializedName("nota_dos") val nota_dos: String? = null,
    @SerializedName("seguro") val seguro: String,
    @SerializedName("image") val image: String? = null
    ): Serializable{
        fun toJson(): String = Gson().toJson(Formulario(
            id,
            consulta,
            name_med,
            name,
            tipo_documento,
            num_documento,
            sexo,
            fecha,
            telefono,
            antecedentes_medicos,
            RH,
            historial_familiar,
            medicamentos_ac,
            historial_vacunas,
            nota_uno,
            nota_dos?: "",
            seguro,
            if (!image.isNullOrBlank()) URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
        ))

    companion object{
        fun fromJson(data: String): Formulario = Gson().fromJson(data, Formulario::class.java)
    }
    }
