package com.procex.procexapp.domain.useCase.formulario

import com.procex.procexapp.domain.repository.FormularioRepository

class FindByTypeUseCase(private val repository: FormularioRepository) {

    suspend operator fun invoke(tipo_documento: String) = repository.findByType(tipo_documento)

}