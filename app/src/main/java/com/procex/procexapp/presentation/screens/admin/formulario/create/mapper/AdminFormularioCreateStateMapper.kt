package com.procex.procexapp.presentation.screens.admin.formulario.create.mapper

import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.presentation.screens.admin.formulario.create.AdminFormularioCreateState

fun AdminFormularioCreateState.toFormulario(): Formulario {
    return Formulario(
            consulta = consulta,
            name_med = name_med,
            name = name,
            tipo_documento = tipo_documento,
            num_documento = num_documento,
            RH = RH,
            sexo = sexo,
            fecha = fecha,
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
            resultado_ta = resultado_ta,
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