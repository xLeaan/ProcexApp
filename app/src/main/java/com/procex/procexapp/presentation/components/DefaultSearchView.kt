package com.procex.procexapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TopAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.procex.procexapp.presentation.navigation.screen.client.ClientFormularioScreen

@Composable
fun DefaultSearchView(
    value: String,
    onValueChange: (value: String) -> Unit,
    onTipoDocumentoChange: (selectedTP: String) -> Unit,
    navController: NavHostController,
    onClick: () -> Unit
) {
    val opcionesTP = listOf("RC", "TI", "CE", "CC", "PA", "MS", "AS", "CN", "PE", "SC", "CD", "PT")
    var TPExpanded by remember { mutableStateOf(false) }
    var selectedTP by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = "Filtrar",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp),
            color = Color.Gray
        )
        androidx.compose.material.Card(
            modifier = Modifier
                .padding(bottom = 15.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    DropdownMenu(
                        expanded = TPExpanded,
                        onDismissRequest = { TPExpanded = false }
                    ) {
                        opcionesTP.forEach { option ->
                            DropdownMenuItem(
                                onClick = {
                                    TPExpanded = false
                                    selectedTP = option
                                    onTipoDocumentoChange(option)
                                }
                            ) {
                                Text(text = option)
                            }
                        }
                    }

                    OutlinedTextField(
                        value = selectedTP,
                        onValueChange = {},
                        label = { Text("tipo docum.") },
                        singleLine = true,
                        readOnly = true,
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Expandir documento",
                                modifier = Modifier.clickable { TPExpanded = true }
                            )
                        }
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = value,
                        onValueChange = { text ->
                            onValueChange(text)
                        },
                        label = {
                            Text(
                                text = "num. documento",
                                fontSize = 15.sp
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            backgroundColor = Color.Transparent,
                            focusedBorderColor = Color.Blue,
                            unfocusedBorderColor = Color.White
                        ),
                        textStyle = TextStyle.Default.copy(fontSize = 20.sp)
                    )
                }

                IconButton(onClick = { onClick() }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = Color.Gray
                    )
                }
            }
        }
    }
}







