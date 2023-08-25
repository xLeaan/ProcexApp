package com.procex.procexapp.domain.useCase.formulario

import com.procex.procexapp.domain.repository.FormularioRepository

class FindVisitasEfectivasUseCase(private val repository: FormularioRepository) {

    suspend operator fun invoke(cl_visita: String) = repository.findVisitasEfectivas(cl_visita)

}