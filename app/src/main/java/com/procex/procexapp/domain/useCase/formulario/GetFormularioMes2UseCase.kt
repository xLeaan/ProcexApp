package com.procex.procexapp.domain.useCase.formulario

import com.procex.procexapp.domain.repository.FormularioRepository

class GetFormularioMes2UseCase(private val repository: FormularioRepository) {

    suspend operator fun invoke(created_at: String) = repository.findByMes2(created_at)

}