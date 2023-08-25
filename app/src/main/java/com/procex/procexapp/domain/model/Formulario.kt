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
    @SerializedName("RH") val RH: String,
    @SerializedName("fecha") val fecha: String,
    @SerializedName("telefono") val telefono: String,
    @SerializedName("tipo_visita") val tipo_visita: String,
    @SerializedName("cl_visita") val cl_visita: String,
    @SerializedName("causa") val causa: String,
    @SerializedName("direccion") val direccion: String,
    @SerializedName("barrio") val barrio: String,
    @SerializedName("propiedad") val propiedad: String,
    @SerializedName("tensiona") val tensiona: String,
    @SerializedName("tipo_ta") val tipo_ta: String,
    @SerializedName("toma_ta") val toma_ta: String,
    @SerializedName("resultado_ta") val resultado_ta: String,
    @SerializedName("oximetria") val oximetria: String,
    @SerializedName("toma_oxi") val toma_oxi: String,
    @SerializedName("resultado_oxi") val resultado_oxi: String,
    @SerializedName("findrisk") val findrisk: String,
    @SerializedName("estatura") val estatura: String,
    @SerializedName("peso") val peso: String,
    @SerializedName("nota_uno") val nota_uno: String,
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
            RH,
            fecha,
            telefono,
            tipo_visita,
            cl_visita,
            causa,
            direccion,
            barrio,
            propiedad,
            tensiona,
            tipo_ta,
            toma_ta,
            resultado_ta,
            oximetria,
            toma_oxi,
            resultado_oxi,
            findrisk,
            estatura,
            peso,
            nota_uno,
            if (!image.isNullOrBlank()) URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
        ))

    companion object{
        fun fromJson(data: String): Formulario = Gson().fromJson(data, Formulario::class.java)
    }
    }
