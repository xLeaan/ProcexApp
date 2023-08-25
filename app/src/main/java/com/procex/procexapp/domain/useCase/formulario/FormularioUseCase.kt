package com.procex.procexapp.domain.useCase.formulario

data class FormularioUseCase(
    val createFormulario: CreateFormularioUseCase,
    val getFormulario: GetFormularioUseCase,
    val updateFormulario: UpdateFormularioUseCase,
    val updateFormularioWithImage: UpdateFormularioWithImageUseCase,
    val deleteFormulario: DeleteFormularioUseCase,
    val findByNum: FindByNumUseCase,
    val findByType: FindByTypeUseCase,
    val findByTypeAndNum: FindByTypeAndNumUseCase,
    val findBySexoF: FindBySexoFUseCase,
    val findBySexoM: FindBySexoMUseCase,
    val findByMes1: GetFormularioMes1UseCase,
    val findByMes2: GetFormularioMes2UseCase,
    val findVisitasEfectivas: FindVisitasEfectivasUseCase,
    val findVisitasNoEfectivas: FindVisitasNoEfectivasUseCase
)
