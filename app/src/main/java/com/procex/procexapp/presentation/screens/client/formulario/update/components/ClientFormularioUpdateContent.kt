package com.procex.procexapp.presentation.screens.client.formulario.update.components

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
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
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
import com.procex.procexapp.presentation.screens.client.formulario.update.ClientFormularioUpdateViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun ClientFormularioUpdateContent(paddingValues: PaddingValues, vm: ClientFormularioUpdateViewModel = hiltViewModel()) {
    val state = vm.state
    vm.resultingActivityHandler.handle()
    val stateDialog = remember { mutableStateOf(false) }

    val opcionesSexo = listOf("Femenino", "Masculino")
    var sexoExpanded by remember { mutableStateOf(false) }

    val opcionesRH = listOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")
    var RHExpanded by remember { mutableStateOf(false) }

    val opcionesTP = listOf("RC", "TI", "CE", "CC", "PA", "MS", "AS", "CN", "PE", "SC", "CD", "PT")
    var TPExpanded by remember { mutableStateOf(false) }

    val selectedDate = remember { mutableStateOf(Calendar.getInstance()) }
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val formattedDate = remember { mutableStateOf(dateFormat.format(selectedDate.value.time)) }

    val context = LocalContext.current

    DialogCapturePicture(
        state = stateDialog,
        takePhoto = { vm.takePhoto()},
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
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.name_med,
                    onValueChange = { vm.onName_medInput(it) },
                    label = "Nombre médico",
                    icon = Icons.Default.Person
                )
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.name,
                    onValueChange = { vm.onNameInput(it) },
                    label = "Nombre paciente",
                    icon = Icons.Default.Person
                )
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
                    icon = Icons.Default.Face
                )
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
                Text("La edad actual es: ${calculateAge(state.fecha)}")
                Spacer(modifier = Modifier.height(5.dp))
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.fecha,
                    onValueChange = {  },
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
                    keyboardType = KeyboardType.Phone
                )
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.antecedentes_medicos,
                    onValueChange = { vm.onAntecedentes_medicosInput(it) },
                    label = "Antecedentes médicos",
                    icon = Icons.Default.Info
                )
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
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.historial_familiar,
                    onValueChange = { vm.onHistorial_familiarInput(it) },
                    label = "Historial familiar",
                    icon = Icons.Default.Info
                )
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.medicamentos_ac,
                    onValueChange = { vm.onMedicamentos_acInput(it) },
                    label = "Medicamentos actuales",
                    icon = Icons.Default.Info
                )
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.antecedentes_medicos,
                    onValueChange = { vm.onAntecedentes_medicosInput(it) },
                    label = "Antecedentes médicos",
                    icon = Icons.Default.Info
                )
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.historial_vacunas,
                    onValueChange = { vm.onHistorial_vacunasInput(it) },
                    label = "Historial de vacunas",
                    icon = Icons.Default.Info
                )
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.nota_uno,
                    onValueChange = { vm.onNota_unoInput(it) },
                    label = "Nota uno",
                    icon = Icons.Default.Info
                )
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.nota_dos?: "",
                    onValueChange = { vm.onNota_dosInput(it) },
                    label = "Nota dos",
                    icon = Icons.Default.Info
                )
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.seguro,
                    onValueChange = { vm.onSeguroInput(it) },
                    label = "Seguro",
                    icon = Icons.Default.Lock
                )
                DefaultButton(modifier = Modifier.fillMaxWidth(),
                    text = "Actualizar formulario",
                    onClick = { vm.onUpdate() }
                )
                DefaultButton(modifier = Modifier.fillMaxWidth(),
                    text = "Subir formulario",
                    onClick = { vm.createFormulario() }
                )
            }

        }
    }

