package com.procex.procexapp.domain.useCase.formulario

import com.procex.procexapp.domain.repository.FormularioRepository

class FindReadyUseCase(private val repository: FormularioRepository) {

    suspend operator fun invoke(estado: String) = repository.findReady(estado)

}