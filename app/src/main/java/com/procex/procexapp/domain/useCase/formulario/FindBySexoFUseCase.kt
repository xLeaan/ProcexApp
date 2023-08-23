package com.procex.procexapp.domain.useCase.formulario

import com.procex.procexapp.domain.repository.FormularioRepository

class FindBySexoFUseCase(private val repository: FormularioRepository) {

    suspend operator fun invoke(sexo: String) = repository.findBySexoF(sexo)

}