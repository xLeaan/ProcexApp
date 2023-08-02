package com.procex.procexapp.domain.useCase.formulario

import com.procex.procexapp.domain.repository.FormularioRepository

class FindByNumUseCase(private val repository: FormularioRepository) {

    suspend operator fun invoke(num_documento: String) = repository.findByNum(num_documento)

}