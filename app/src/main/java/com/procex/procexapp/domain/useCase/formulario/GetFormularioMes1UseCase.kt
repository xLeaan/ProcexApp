package com.procex.procexapp.domain.useCase.formulario

import com.procex.procexapp.domain.repository.FormularioRepository

class GetFormularioMes1UseCase(private val repository: FormularioRepository) {

    suspend operator fun invoke(created_at: String) = repository.findByMes1(created_at)

}