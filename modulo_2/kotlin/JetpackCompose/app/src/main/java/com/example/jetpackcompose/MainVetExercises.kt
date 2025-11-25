package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/* ------------------------------------------------------
    RUTAS DE NAVEGACIÓN
------------------------------------------------------- */
sealed class VetScreen(val route: String) {
    object Home : VetScreen("vet_home")
    object Dosis : VetScreen("vet_dosis")
    object Alimentacion : VetScreen("vet_alimentacion")
    object Costos : VetScreen("vet_costos")
}

/* ------------------------------------------------------
    MAIN ACTIVITY
------------------------------------------------------- */
class MainVetExercises : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { VetNavApp() }
    }
}

/* ------------------------------------------------------
    NAVIGATION HOST
------------------------------------------------------- */
@Composable
fun VetNavApp() {
    val nav = rememberNavController()

    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHost(nav, startDestination = VetScreen.Home.route) {

                composable(VetScreen.Home.route) { VetHomeScreen(nav) }
                composable(VetScreen.Dosis.route) { VetDosisScreen(nav) }
                composable(VetScreen.Alimentacion.route) { VetAlimentacionScreen(nav) }
                composable(VetScreen.Costos.route) { VetCostosScreen(nav) }
            }
        }
    }
}

/* ======================================================
    PANTALLA PRINCIPAL — MENÚ
========================================================= */
@Composable
fun VetHomeScreen(nav: NavHostController) {
    val bg = Color(0xFF0F172A)
    val card = Color(0xFF1E293B)
    val accent = Color(0xFF38BDF8)

    Box(
        modifier = Modifier.fillMaxSize().background(bg),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.padding(20.dp),
            colors = CardDefaults.cardColors(card)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Clínica Vet Express",
                    color = accent,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text("Herramientas rápidas veterinarias",
                    color = Color(0xFFCBD5E1)
                )

                Button(onClick = { nav.navigate(VetScreen.Dosis.route) },
                    modifier = Modifier.fillMaxWidth()
                ) { Text("Dosis de medicamento") }

                Button(onClick = { nav.navigate(VetScreen.Alimentacion.route) },
                    modifier = Modifier.fillMaxWidth()
                ) { Text("Plan de alimentación") }

                Button(onClick = { nav.navigate(VetScreen.Costos.route) },
                    modifier = Modifier.fillMaxWidth()
                ) { Text("Costo visita + vacunas") }
            }
        }
    }
}

/* ======================================================
    PANTALLA 1 — DOSIS DE MEDICAMENTO
========================================================= */
@Composable
fun VetDosisScreen(nav: NavController) {
    var peso by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("") } // perro o gato

    val dosis = calcularDosis(peso)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Dosis estimada",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = tipo,
            onValueChange = { tipo = it },
            label = { Text("Tipo de mascota (perro/gato)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso en kg") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Dosis estimada: ${"%.2f".format(dosis)} ml")
        Text("Consulta al veterinario si tienes dudas.")

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Regresar") }
    }
}

/* ======================================================
    PANTALLA 2 — PLAN DE ALIMENTACIÓN
========================================================= */
@Composable
fun VetAlimentacionScreen(nav: NavController) {
    var tipo by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var actividad by remember { mutableStateOf("Baja") }

    val gramos = calcularRacion(peso, actividad)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Plan de alimentación",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = tipo,
            onValueChange = { tipo = it },
            label = { Text("Tipo de mascota") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso (kg)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Selector básico
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            listOf("Baja", "Media", "Alta").forEach {
                Button(onClick = { actividad = it }) {
                    Text(it)
                }
            }
        }

        Text("Ración diaria aproximada: ${"%.0f".format(gramos)} g")
        Text("Repartir en 2 a 3 comidas.")

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Regresar") }
    }
}

/* ======================================================
    PANTALLA 3 — COSTO VISITA + VACUNAS
========================================================= */
@Composable
fun VetCostosScreen(nav: NavController) {
    var consulta by remember { mutableStateOf("") }
    var costoVacuna by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }

    val total = calcularCostoTotal(consulta, costoVacuna, cantidad)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Costo visita + vacunas",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = consulta,
            onValueChange = { consulta = it },
            label = { Text("Costo base consulta") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = costoVacuna,
            onValueChange = { costoVacuna = it },
            label = { Text("Costo por vacuna") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text("Cantidad de vacunas") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Total a pagar: $${"%.2f".format(total)}")

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Regresar") }
    }
}

/* ------------------------------------------------------
    FUNCIONES LÓGICAS
------------------------------------------------------- */

fun calcularDosis(peso: String): Double {
    val p = peso.toDoubleOrNull() ?: 0.0
    return p * 0.8 // Ejemplo: 0.8 ml por kg
}

fun calcularRacion(peso: String, actividad: String): Double {
    val p = peso.toDoubleOrNull() ?: 0.0
    val factor = when (actividad) {
        "Alta" -> 35
        "Media" -> 30
        else -> 25
    }
    return p * factor
}

fun calcularCostoTotal(consulta: String, costoVacuna: String, cantidad: String): Double {
    val c = consulta.toDoubleOrNull() ?: 0.0
    val v = costoVacuna.toDoubleOrNull() ?: 0.0
    val cant = cantidad.toIntOrNull() ?: 0
    return c + (v * cant)
}

@Preview(showBackground = true)
@Composable
fun PreviewVetApp() {
    VetNavApp()
}
