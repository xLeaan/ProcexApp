package com.procex.procexapp.domain.useCase.formulario

import com.procex.procexapp.domain.model.Formulario
import com.procex.procexapp.domain.repository.FormularioRepository
import java.io.File

class UpdateFormularioWithImageUseCase(private val repository: FormularioRepository) {

    suspend operator fun invoke(id: String, formulario: Formulario, file: File) = repository.updateWithImage(id, formulario, file)

}