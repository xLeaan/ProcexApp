package com.procex.procexapp.domain.useCase.formulario

import com.procex.procexapp.domain.repository.FormularioRepository

class DeleteFormularioUseCase(private val repository: FormularioRepository) {
    suspend operator fun invoke(id: String) = repository.delete(id)
}