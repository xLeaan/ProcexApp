package com.procex.procexapp.presentation.screens.admin.formulario.update.components

import android.app.DatePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.procex.procexapp.R
import com.procex.procexapp.presentation.components.DefaultButton
import com.procex.procexapp.presentation.components.DefaultTextField
import com.procex.procexapp.presentation.components.DialogCapturePicture
import com.procex.procexapp.presentation.screens.admin.formulario.update.AdminFormularioUpdateViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun AdminFormularioUpdateContent(paddingValues: PaddingValues, vm: AdminFormularioUpdateViewModel = hiltViewModel()) {
    val state = vm.state
    vm.resultingActivityHandler.handle()
    val stateDialog = remember { mutableStateOf(false) }

    val opcionesEstado = listOf("Listo", "Pendiente")
    var estadoExpanded by remember { mutableStateOf(false) }

    val opcionesSexo = listOf("Femenino", "Masculino")
    var sexoExpanded by remember { mutableStateOf(false) }

    val opcionesRH = listOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")
    var RHExpanded by remember { mutableStateOf(false) }

    val opcionesTP = listOf("RC", "TI", "CE", "CC", "PA", "MS", "AS", "CN", "PE", "SC", "CD", "PT")
    var TPExpanded by remember { mutableStateOf(false) }

    val opcionesTV = listOf("Primera vez", "Salud publica", "Seguimiento")
    var TVExpanded by remember { mutableStateOf(false) }

    val opcionesVisita = listOf("Efectiva", "No efectiva")
    var visitaExpanded by remember { mutableStateOf(false) }

    val opcionesPropiedad = listOf("Sí", "No")
    var propiedadExpanded by remember { mutableStateOf(false) }

    val opcionesTA = listOf("Sistólica", "Diastólica")
    var TAExpanded by remember { mutableStateOf(false) }

    val selectedDate = remember { mutableStateOf(Calendar.getInstance()) }
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val formattedDate = remember { mutableStateOf(dateFormat.format(selectedDate.value.time)) }

    val context = LocalContext.current

    DialogCapturePicture(
        state = stateDialog,
        takePhoto = { vm.takePhoto() },
        pickImage = { vm.pickImage() }
    )

    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        if (!state.image.isNullOrBlank()) {
            AsyncImage(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .clickable { stateDialog.value = true },
                model = state.image,
                contentDescription = ""
            )
        } else {
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .clickable { stateDialog.value = true },
                painter = painterResource(id = R.drawable.formulario),
                contentDescription = "Imagen formulario"
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = state.estado,
                    onValueChange = { vm.onEstadoInput(it) },
                    label = { Text("Estado del formulario") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Expandir estado",
                            modifier = Modifier.clickable { estadoExpanded = true }
                        )
                    }
                )
                DropdownMenu(
                    expanded = estadoExpanded,
                    onDismissRequest = { estadoExpanded = false }
                ) {
                    opcionesEstado.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                vm.onEstadoInput(option)
                                estadoExpanded = false
                            }
                        ) {
                            Text(text = option)
                        }
                    }
                }
            }
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.name_med,
                onValueChange = { vm.onName_medInput(it) },
                label = "Nombre promotor",
                icon = Icons.Default.Person
            )
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.name,
                onValueChange = { vm.onNameInput(it) },
                label = "Nombre paciente",
                icon = Icons.Default.Person
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = state.tipo_documento,
                    onValueChange = { vm.onTipo_documentoInput(it) },
                    label = { Text("Tipo documento") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Expandir documento",
                            modifier = Modifier.clickable { TPExpanded = true }
                        )
                    }
                )
                DropdownMenu(
                    expanded = TPExpanded,
                    onDismissRequest = { TPExpanded = false }
                ) {
                    opcionesTP.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                vm.onTipo_documentoInput(option)
                                TPExpanded = false
                            }
                        ) {
                            Text(text = option)
                        }
                    }
                }
            }
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.num_documento,
                onValueChange = { vm.onNum_documentoInput(it) },
                label = "Numero documento",
                icon = Icons.Default.Face,
                keyboardType = KeyboardType.Number
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = state.sexo,
                    onValueChange = { vm.onSexoInput(it) },
                    label = { Text("Género") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Expandir sexo",
                            modifier = Modifier.clickable { sexoExpanded = true }
                        )
                    }
                )
                DropdownMenu(
                    expanded = sexoExpanded,
                    onDismissRequest = { sexoExpanded = false }
                ) {
                    opcionesSexo.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                vm.onSexoInput(option)
                                sexoExpanded = false
                            }
                        ) {
                            Text(text = option)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            fun calculateAge(birthDate: String): Int {
                if (birthDate.isEmpty()) return 0

                val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                val currentDate = Calendar.getInstance()

                val userDate = Calendar.getInstance()
                userDate.time = dateFormat.parse(birthDate)

                var age = currentDate.get(Calendar.YEAR) - userDate.get(Calendar.YEAR)
                if (currentDate.get(Calendar.DAY_OF_YEAR) < userDate.get(Calendar.DAY_OF_YEAR)) {
                    age--
                }

                return age
            }

            fun calculateBMI(peso: String, estatura: String, edad: Int): Float? {
                if (peso.isEmpty() || estatura.isEmpty() || edad < 18) return null

                val pesoFloat = peso.toFloatOrNull()
                val estaturaFloat = estatura.toFloatOrNull()

                if (pesoFloat != null && estaturaFloat != null) {
                    // Calcular el IMC
                    val alturaMetros = estaturaFloat / 100 // Convertir la estatura de cm a m
                    val imc = pesoFloat / (alturaMetros * alturaMetros)
                    return imc
                }

                return null
            }

            fun calcularPorcentaje(edad: Int, peso: String): String {

                val pesoFloat = peso.toFloatOrNull()

                if (edad == 1 && pesoFloat != null) {
                    val resultado = (pesoFloat / 10) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                } else if (edad == 2 && pesoFloat != null) {
                    val resultado = (pesoFloat / 13) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                } else if (edad == 3 && pesoFloat != null) {
                    val resultado = (pesoFloat / 15) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                } else if (edad == 4 && pesoFloat != null) {
                    val resultado = (pesoFloat / 17) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                }
                else if (edad == 5 && pesoFloat != null) {
                    val resultado = (pesoFloat / 19) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                } else if (edad == 6 && pesoFloat != null) {
                    val resultado = (pesoFloat / 21) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                } else if (edad == 7 && pesoFloat != null) {
                    val resultado = (pesoFloat / 23) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                } else if (edad == 8 && pesoFloat != null) {
                    val resultado = (pesoFloat / 26) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                } else if (edad == 9 && pesoFloat != null) {
                    val resultado = (pesoFloat / 29) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                } else if (edad == 10 && pesoFloat != null) {
                    val resultado = (pesoFloat / 32) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                } else if (edad == 11 && pesoFloat != null) {
                    val resultado = (pesoFloat / 36) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                } else if (edad == 12 && pesoFloat != null) {
                    val resultado = (pesoFloat / 41) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                } else if (edad == 13 && pesoFloat != null) {
                    val resultado = (pesoFloat / 47) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                } else if (edad == 14 && pesoFloat != null) {
                    val resultado = (pesoFloat / 52) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                } else if (edad == 15 && pesoFloat != null) {
                    val resultado = (pesoFloat / 57) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                } else if (edad == 16 && pesoFloat != null) {
                    val resultado = (pesoFloat / 62) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                } else if (edad == 17 && pesoFloat != null) {
                    val resultado = (pesoFloat / 66) * 100
                    if (resultado <= 85) {
                        return "Desnutrición severa"
                    } else if (resultado <= 86 && resultado >= 89) {
                        return "Desnutrición moderada"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Desnutrición leve"
                    } else if (resultado <= 90 && resultado >= 95) {
                        return "Normal"
                    }
                }
                return "El paciente puede estar por encima de su peso esperado"
            }


            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = 4.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val edad = calculateAge(state.fecha)
                    val imc = calculateBMI(state.peso, state.estatura, edad)
                    val desnutricion = calcularPorcentaje(edad, state.peso)

                    if (imc != null) {
                        Column {
                            Text("Edad: $edad")
                            Spacer(modifier = Modifier.height(10.dp))
                            Text("IMC: $imc")
                        }
                    } else if (edad < 18){
                        Text("Edad: $edad")
                        Spacer(modifier = Modifier.height(10.dp))
                        Text("Peso: $desnutricion")
                    }
                    else {
                        Text("Edad: $edad")
                        Spacer(modifier = Modifier.height(10.dp))
                        Text("No se puede calcular por falta de datos")
                    }
                }
            }

            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = state.RH,
                    onValueChange = { vm.onRHInput(it) },
                    label = { Text("RH") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Expandir",
                            modifier = Modifier.clickable { RHExpanded = true }
                        )
                    }
                )
                DropdownMenu(
                    expanded = RHExpanded,
                    onDismissRequest = { RHExpanded = false }
                ) {
                    opcionesRH.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                vm.onRHInput(option)
                                RHExpanded = false
                            }
                        ) {
                            Text(text = option)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = formattedDate.value,
                onValueChange = { },
                label = { Text("Fecha") },
                trailingIcon = {
                    Icon(Icons.Default.DateRange, contentDescription = "Fecha")
                }
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val datePicker = DatePickerDialog(
                        context,
                        { _, year, month, dayOfMonth ->
                            vm.onFechaInput(year, month, dayOfMonth)
                            val selectedCalendar = Calendar.getInstance()
                            selectedCalendar.set(year, month, dayOfMonth)
                            formattedDate.value = dateFormat.format(selectedCalendar.time)
                        },
                        selectedDate.value.get(Calendar.YEAR),
                        selectedDate.value.get(Calendar.MONTH),
                        selectedDate.value.get(Calendar.DAY_OF_MONTH)
                    )
                    datePicker.show()
                }
            ) {
                Text("Seleccionar fecha")
            }
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.telefono,
                onValueChange = { vm.onTelefonoInput(it) },
                label = "Télefono",
                icon = Icons.Default.Phone,
                keyboardType = KeyboardType.Number
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = state.tipo_visita,
                    onValueChange = { vm.onTipo_visitaInput(it) },
                    label = { Text("Tipo de visita") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Expandir tipo visita",
                            modifier = Modifier.clickable { TVExpanded = true }
                        )
                    }
                )
                DropdownMenu(
                    expanded = TVExpanded,
                    onDismissRequest = { TVExpanded = false }
                ) {
                    opcionesTV.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                vm.onTipo_visitaInput(option)
                                TVExpanded = false
                            }
                        ) {
                            Text(text = option)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = state.cl_visita,
                    onValueChange = { vm.onCl_visitaInput(it) },
                    label = { Text("Clasificación de la visita") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Expandir visita",
                            modifier = Modifier.clickable { visitaExpanded = true }
                        )
                    }
                )
                DropdownMenu(
                    expanded = visitaExpanded,
                    onDismissRequest = { visitaExpanded = false }
                ) {
                    opcionesVisita.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                vm.onCl_visitaInput(option)
                                visitaExpanded = false
                            }
                        ) {
                            Text(text = option)
                        }
                    }
                }
            }
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.causa,
                onValueChange = { vm.onCausaInput(it) },
                label = "Causa de no efectividad(opcional)",
                icon = Icons.Default.Close
            )
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.direccion,
                onValueChange = { vm.onDireccionInput(it) },
                label = "Dirección",
                icon = Icons.Default.LocationOn
            )
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.barrio,
                onValueChange = { vm.onBarrioInput(it) },
                label = "Barrio",
                icon = Icons.Default.LocationOn
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = state.propiedad,
                    onValueChange = { vm.onPropiedadInput(it) },
                    label = { Text("¿Está en la propiedad?") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Expandir propiedad",
                            modifier = Modifier.clickable { propiedadExpanded = true }
                        )
                    }
                )
                DropdownMenu(
                    expanded = propiedadExpanded,
                    onDismissRequest = { propiedadExpanded = false }
                ) {
                    opcionesPropiedad.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                vm.onPropiedadInput(option)
                                propiedadExpanded = false
                            }
                        ) {
                            Text(text = option)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = state.tensiona,
                    onValueChange = { vm.onTensionaInput(it) },
                    label = { Text("Toma TA") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Expandir TA",
                            modifier = Modifier.clickable { propiedadExpanded = true }
                        )
                    }
                )
                DropdownMenu(
                    expanded = propiedadExpanded,
                    onDismissRequest = { propiedadExpanded = false }
                ) {
                    opcionesPropiedad.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                vm.onTensionaInput(option)
                                propiedadExpanded = false
                            }
                        ) {
                            Text(text = option)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = state.tipo_ta,
                    onValueChange = { vm.onTipo_taInput(it) },
                    label = { Text("Tipo TA") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Expandir tipo TA",
                            modifier = Modifier.clickable { TAExpanded = true }
                        )
                    }
                )
                DropdownMenu(
                    expanded = TAExpanded,
                    onDismissRequest = { TAExpanded = false }
                ) {
                    opcionesTA.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                vm.onTipo_taInput(option)
                                TAExpanded = false
                            }
                        ) {
                            Text(text = option)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = formattedDate.value,
                onValueChange = { },
                label = { Text("Fecha toma TA") },
                trailingIcon = {
                    Icon(Icons.Default.DateRange, contentDescription = "Fecha toma TA")
                }
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val datePicker = DatePickerDialog(
                        context,
                        { _, year, month, dayOfMonth ->
                            vm.onToma_taInput(year, month, dayOfMonth)
                            val selectedCalendar = Calendar.getInstance()
                            selectedCalendar.set(year, month, dayOfMonth)
                            formattedDate.value = dateFormat.format(selectedCalendar.time)
                        },
                        selectedDate.value.get(Calendar.YEAR),
                        selectedDate.value.get(Calendar.MONTH),
                        selectedDate.value.get(Calendar.DAY_OF_MONTH)
                    )
                    datePicker.show()
                }
            ) {
                Text("Fecha toma TA")
            }
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = state.oximetria,
                    onValueChange = { vm.onOximetriaInput(it) },
                    label = { Text("Oximetría") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Expandir",
                            modifier = Modifier.clickable { propiedadExpanded = true }
                        )
                    }
                )
                DropdownMenu(
                    expanded = propiedadExpanded,
                    onDismissRequest = { propiedadExpanded = false }
                ) {
                    opcionesPropiedad.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                vm.onOximetriaInput(option)
                                propiedadExpanded = false
                            }
                        ) {
                            Text(text = option)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = formattedDate.value,
                onValueChange = { },
                label = { Text("Fecha toma Oximetría") },
                trailingIcon = {
                    Icon(Icons.Default.DateRange, contentDescription = "Fecha toma Oximetría")
                }
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val datePicker = DatePickerDialog(
                        context,
                        { _, year, month, dayOfMonth ->
                            vm.onToma_oxiInput(year, month, dayOfMonth)
                            val selectedCalendar = Calendar.getInstance()
                            selectedCalendar.set(year, month, dayOfMonth)
                            formattedDate.value = dateFormat.format(selectedCalendar.time)
                        },
                        selectedDate.value.get(Calendar.YEAR),
                        selectedDate.value.get(Calendar.MONTH),
                        selectedDate.value.get(Calendar.DAY_OF_MONTH)
                    )
                    datePicker.show()
                }
            ) {
                Text("Fecha toma Oximetría")
            }
            Spacer(modifier = Modifier.height(5.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = formattedDate.value,
                onValueChange = { },
                label = { Text("Fecha resultado Oximetría") },
                trailingIcon = {
                    Icon(Icons.Default.DateRange, contentDescription = "Fecha resultado Oximetría")
                }
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val datePicker = DatePickerDialog(
                        context,
                        { _, year, month, dayOfMonth ->
                            vm.onResultado_oxiInput(year, month, dayOfMonth)
                            val selectedCalendar = Calendar.getInstance()
                            selectedCalendar.set(year, month, dayOfMonth)
                            formattedDate.value = dateFormat.format(selectedCalendar.time)
                        },
                        selectedDate.value.get(Calendar.YEAR),
                        selectedDate.value.get(Calendar.MONTH),
                        selectedDate.value.get(Calendar.DAY_OF_MONTH)
                    )
                    datePicker.show()
                }
            ) {
                Text("Fecha resultado Oximetría")
            }
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = state.findrisk,
                    onValueChange = { vm.onFindriskInput(it) },
                    label = { Text("Medición Findrisk") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Expandir",
                            modifier = Modifier.clickable { propiedadExpanded = true }
                        )
                    }
                )
                DropdownMenu(
                    expanded = propiedadExpanded,
                    onDismissRequest = { propiedadExpanded = false }
                ) {
                    opcionesPropiedad.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                vm.onFindriskInput(option)
                                propiedadExpanded = false
                            }
                        ) {
                            Text(text = option)
                        }
                    }
                }
            }
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.estatura,
                onValueChange = { vm.onEstaturaInput(it) },
                label = "Estatura",
                icon = Icons.Default.MoreVert,
                keyboardType = KeyboardType.Number
            )
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.peso,
                onValueChange = { vm.onPesoInput(it) },
                label = "Peso",
                icon = Icons.Default.Person,
                keyboardType = KeyboardType.Number
            )
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.nota_uno,
                onValueChange = { vm.onNota_unoInput(it) },
                label = "Nota",
                icon = Icons.Default.Info
            )
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Subir formulario",
                onClick = { vm.createFormulario() }
            )
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Actualizar formulario",
                onClick = { vm.onUpdate() }
            )

        }
    }
}