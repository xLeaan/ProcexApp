package com.procex.procexapp.presentation.screens.client.formulario.update.mapper

import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.presentation.screens.client.formulario.update.ClientFormularioUpdateState

fun ClientFormularioUpdateState.toFormulario(): Formulario {
    return Formulario(
            name_med = name_med,
            name = name,
            tipo_documento = tipo_documento,
            num_documento = num_documento,
            sexo = sexo,
            RH = RH,
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
            image = image
    )
}