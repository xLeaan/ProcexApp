package com.procex.procexapp.presentation.navigation.screen.admin

sealed class AdminFormularioScreen(val route: String){

    object FormularioCreate: AdminFormularioScreen("admin/formulario/create")
    object FormularioUpdate: AdminFormularioScreen("admin/formulario/update/{formulario}"){
        fun passFormulario(formulario: String) = "admin/formulario/update/$formulario"
    }


}
