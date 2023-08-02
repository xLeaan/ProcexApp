package com.procex.procexapp.domain.useCase.formulario

import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.domain.repository.FormularioRepository
import java.io.File

class CreateFormularioUseCase(private val repository: FormularioRepository) {

    suspend operator fun invoke(formulario: Formulario, file: File) = repository.create(formulario, file)

}