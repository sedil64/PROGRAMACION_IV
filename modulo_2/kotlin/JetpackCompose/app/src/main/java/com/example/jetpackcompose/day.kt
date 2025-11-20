package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/* -----------------------------------------------
   RUTAS (igual al ejemplo que enviaste)
------------------------------------------------ */
sealed class DayScreen(val route: String) {
    object Home : DayScreen("day_home")
    object Hidratacion : DayScreen("hidratacion")
    object Estudio : DayScreen("estudio")
    object Transporte : DayScreen("transporte")
}

/* -----------------------------------------------
   MAIN ACTIVITY
------------------------------------------------ */
class MainDayExercises : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { DayNavApp() }
    }
}

/* -----------------------------------------------
   NAVIGATION HOST
------------------------------------------------ */
@Composable
fun DayNavApp() {
    val nav = rememberNavController()
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = nav,
                startDestination = DayScreen.Home.route
            ) {
                composable(DayScreen.Home.route) { DayHomeScreen(nav) }
                composable(DayScreen.Hidratacion.route) { HidratacionScreen(nav) }
                composable(DayScreen.Estudio.route) { EstudioScreen(nav) }
                composable(DayScreen.Transporte.route) { TransporteScreen(nav) }
            }
        }
    }
}

/* -----------------------------------------------
   PANTALLA PRINCIPAL (MENÚ)
------------------------------------------------ */
@Composable
fun DayHomeScreen(nav: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Mi Día Inteligente",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = { nav.navigate(DayScreen.Hidratacion.route) },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Hidratación diaria") }

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = { nav.navigate(DayScreen.Estudio.route) },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Estudio semanal") }

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = { nav.navigate(DayScreen.Transporte.route) },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Transporte mensual") }
    }
}

/* -----------------------------------------------
   PANTALLA 1 — HIDRATACIÓN
------------------------------------------------ */
@Composable
fun HidratacionScreen(nav: NavController) {
    var peso by remember { mutableStateOf("") }
    val litros = calcularLitrosAgua(peso)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Hidratación Diaria",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge
        )

        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso en kg") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Debes tomar: ${"%.2f".format(litros)} litros al día")

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Regresar") }
    }
}

/* -----------------------------------------------
   PANTALLA 2 — ESTUDIO (FOR OBLIGATORIO)
------------------------------------------------ */
@Composable
fun EstudioScreen(nav: NavController) {
    var dias = MutableList(7) { "" }
    val total = calcularTotalEstudio(dias)
    val promedio = if (total > 0) total / 7 else 0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Estudio semanal", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)

        // uso del ciclo FOR como pide el ejercicio
        for (i in 0 until 7) {
            OutlinedTextField(
                value = dias[i],
                onValueChange = { dias[i] = it },
                label = { Text("Minutos día ${i + 1}") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Text("Total: $total minutos")
        Text("Promedio diario: $promedio minutos")

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Regresar") }
    }
}

/* -----------------------------------------------
   PANTALLA 3 — TRANSPORTE
------------------------------------------------ */
@Composable
fun TransporteScreen(nav: NavController) {
    var viajes by remember { mutableStateOf("") }
    var costo by remember { mutableStateOf("") }
    var dias by remember { mutableStateOf("") }

    val total = calcularTransporteMensual(viajes, costo, dias)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Transporte mensual", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = viajes,
            onValueChange = { viajes = it },
            label = { Text("Viajes por día") }
        )

        OutlinedTextField(
            value = costo,
            onValueChange = { costo = it },
            label = { Text("Costo por viaje") }
        )

        OutlinedTextField(
            value = dias,
            onValueChange = { dias = it },
            label = { Text("Días al mes") }
        )

        Text("Gasto mensual estimado: $total $")

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Regresar") }
    }
}

/* -----------------------------------------------
   FUNCIONES DE LÓGICA (abajo como en tu ejemplo)
------------------------------------------------ */

fun calcularLitrosAgua(peso: String): Double {
    val p = peso.replace(",", ".").toDoubleOrNull() ?: 0.0
    return p * 0.033
}

fun calcularTotalEstudio(lista: List<String>): Int {
    var total = 0
    for (i in lista) {
        total += i.toIntOrNull() ?: 0
    }
    return total
}

fun calcularTransporteMensual(viajes: String, costo: String, dias: String): Double {
    val v = viajes.toIntOrNull() ?: 0
    val c = costo.replace(",", ".").toDoubleOrNull() ?: 0.0
    val d = dias.toIntOrNull() ?: 0

    return v * c * d
}

/* -----------------------------------------------
   PREVIEW
------------------------------------------------ */
@Preview(showBackground = true)
@Composable
fun PreviewDayApp() {
    DayNavApp()
}
