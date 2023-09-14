package com.procex.procexapp.data.mapper

import com.procex.procexapp.data.dataSource.local.entity.FormularioEntity
import com.procex.procexapp.domain.model.Formulario

fun FormularioEntity.toFormulario(): Formulario{
    return Formulario(
        id = id,
        estado = estado,
        name_med = name_med,
        name = name,
        tipo_documento = tipo_documento,
        num_documento = num_documento,
        sexo =  sexo,
        RH =  RH,
        fecha =  fecha,
        telefono = telefono,
        tipo_visita = tipo_visita,
        cl_visita = cl_visita,
        causa = causa,
        direccion = direccion,
        barrio = barrio,
        propiedad = propiedad,
        tensiona = tensiona,
        tipo_ta = tipo_ta,
        toma_ta = toma_ta,
        oximetria = oximetria,
        toma_oxi = toma_oxi,
        resultado_oxi = resultado_oxi,
        findrisk = findrisk,
        estatura = estatura,
        peso = peso,
        nota_uno = nota_uno,
        image = image
    )
}

fun Formulario.toFormularioEntity(): FormularioEntity {
    return FormularioEntity(
        id = id ?: "",
        estado = estado,
        name_med = name_med,
        name = name,
        tipo_documento = tipo_documento,
        num_documento = num_documento,
        sexo =  sexo,
        RH =  RH,
        fecha =  fecha,
        telefono = telefono,
        tipo_visita = tipo_visita,
        cl_visita = cl_visita,
        causa = causa,
        direccion = direccion,
        barrio = barrio,
        propiedad = propiedad,
        tensiona = tensiona,
        tipo_ta = tipo_ta,
        toma_ta = toma_ta,
        oximetria = oximetria,
        toma_oxi = toma_oxi,
        resultado_oxi = resultado_oxi,
        findrisk = findrisk,
        estatura = estatura,
        peso = peso,
        nota_uno = nota_uno,
        image = image ?: ""
    )
}