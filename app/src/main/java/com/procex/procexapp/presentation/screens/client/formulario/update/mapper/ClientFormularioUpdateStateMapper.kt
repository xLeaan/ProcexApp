package com.procex.procexapp.presentation.screens.client.formulario.update.mapper

import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.presentation.screens.client.formulario.update.ClientFormularioUpdateState

fun ClientFormularioUpdateState.toFormulario(): Formulario {
    return Formulario(
            consulta = consulta,
            name_med = name_med,
            name = name,
            tipo_documento = tipo_documento,
            num_documento = num_documento,
            sexo = sexo,
            fecha = fecha,
            telefono = telefono,
            antecedentes_medicos = antecedentes_medicos,
            RH = RH,
            historial_familiar = historial_familiar,
            medicamentos_ac = medicamentos_ac,
            historial_vacunas = historial_vacunas,
            nota_uno = nota_uno,
            nota_dos = nota_dos ?: "",
            seguro = seguro
    )
}