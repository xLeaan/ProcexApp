package com.procex.procexapp.domain.useCase.formulario

import com.procex.procexapp.domain.repository.FormularioRepository

class FindVisitasNoEfectivasUseCase(private val repository: FormularioRepository) {

    suspend operator fun invoke(cl_visita: String) = repository.findVisitasNoEfectivas(cl_visita)

}