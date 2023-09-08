package com.procex.procexapp.presentation.navigation.screen.client


sealed class ClientFormularioScreen(val route: String) {
    object FormularioCreate : ClientFormularioScreen("client/formulario/create")
    object FormularioUpdate : ClientFormularioScreen("client/formulario/update/{formulario}") {
        fun passFormulario(formulario: String) = "client/formulario/update/$formulario"
    }
    object Info : ClientFormularioScreen("client/info")
}

