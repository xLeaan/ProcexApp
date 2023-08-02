package com.procex.procexapp.domain.useCase.formulario

import com.procex.procexapp.domain.repository.FormularioRepository

class FindByTypeAndNumUseCase(private val repository: FormularioRepository) {

    suspend operator fun invoke(tipo_documento: String, num_documento: String) = repository.findByTypeAndNum(tipo_documento, num_documento)

}