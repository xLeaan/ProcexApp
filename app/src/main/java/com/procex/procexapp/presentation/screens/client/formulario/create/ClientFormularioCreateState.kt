package com.procex.procexapp.presentation.screens.client.formulario.create

data class ClientFormularioCreateState(
    val consulta: String = "",
    val name_med: String = "",
    val name: String = "",
    val tipo_documento: String = "",
    val num_documento: String = "",
    val sexo: String = "",
    val fecha: String = "",
    val telefono: String = "",
    val antecedentes_medicos: String = "",
    val RH: String = "",
    val historial_familiar: String = "",
    val medicamentos_ac: String = "",
    val historial_vacunas: String = "",
    val nota_uno: String = "",
    val nota_dos: String? = null,
    val seguro: String = "",
    val image: String = "",
)
