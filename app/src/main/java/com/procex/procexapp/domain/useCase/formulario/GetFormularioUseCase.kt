package com.procex.procexapp.domain.useCase.formulario

import com.procex.procexapp.domain.repository.FormularioRepository

class GetFormularioUseCase(private val repository: FormularioRepository) {

    suspend operator fun invoke() = repository.getFormulario()

}