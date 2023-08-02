package com.procex.procexapp.domain.useCase.formulario

data class FormularioUseCase(
    val createFormulario: CreateFormularioUseCase,
    val getFormulario: GetFormularioUseCase,
    val updateFormulario: UpdateFormularioUseCase,
    val updateFormularioWithImage: UpdateFormularioWithImageUseCase,
    val deleteFormulario: DeleteFormularioUseCase,
    val findByNum: FindByNumUseCase,
    val findByType: FindByTypeUseCase,
    val findByTypeAndNum: FindByTypeAndNumUseCase
)
