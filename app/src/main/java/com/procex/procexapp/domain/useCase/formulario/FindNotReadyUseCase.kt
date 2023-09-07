package com.procex.procexapp.domain.useCase.formulario

import com.procex.procexapp.domain.repository.FormularioRepository

class FindNotReadyUseCase(private val repository: FormularioRepository) {

    suspend operator fun invoke(estado: String) = repository.findNotReady(estado)

}