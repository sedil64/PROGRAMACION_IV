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
    RUTAS
------------------------------------------------------- */
sealed class TallerScreen(val route: String) {
    object Home : TallerScreen("taller_home")
    object Combustible : TallerScreen("taller_combustible")
    object Reparacion : TallerScreen("taller_reparacion")
    object Horas : TallerScreen("taller_horas")
}

/* ------------------------------------------------------
    MAIN ACTIVITY
------------------------------------------------------- */
class MainTallerExercises : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { TallerNavApp() }
    }
}

/* ------------------------------------------------------
    NAV HOST
------------------------------------------------------- */
@Composable
fun TallerNavApp() {
    val nav = rememberNavController()
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHost(nav, startDestination = TallerScreen.Home.route) {

                composable(TallerScreen.Home.route) { TallerHomeScreen(nav) }
                composable(TallerScreen.Combustible.route) { CombustibleScreen(nav) }
                composable(TallerScreen.Reparacion.route) { ReparacionScreen(nav) }
                composable(TallerScreen.Horas.route) { HorasScreen(nav) }
            }
        }
    }
}

/* ======================================================
    PANTALLA PRINCIPAL — MENÚ
========================================================= */
@Composable
fun TallerHomeScreen(nav: NavHostController) {
    val bg = Color(0xFF0D1117)     // fondo elegante
    val card = Color(0xFF161B22)   // tarjeta oscura suave
    val accent = Color(0xFF58A6FF) // azul moderno GitHub

    Box(
        modifier = Modifier.fillMaxSize().background(bg),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.padding(20.dp),
            colors = CardDefaults.cardColors(card)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Taller Pro",
                    color = accent,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    "Cálculos rápidos de taller mecánico",
                    color = Color(0xFF8B949E)
                )

                Button(
                    onClick = { nav.navigate(TallerScreen.Combustible.route) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF238636)
                    )
                ) { Text("Consumo de combustible") }

                Button(
                    onClick = { nav.navigate(TallerScreen.Reparacion.route) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0969DA)
                    )
                ) { Text("Costo de reparación") }

                Button(
                    onClick = { nav.navigate(TallerScreen.Horas.route) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF0883E)
                    )
                ) { Text("Horas facturables del día") }
            }
        }
    }
}

/* ======================================================
    PANTALLA 1 — CONSUMO DE COMBUSTIBLE
========================================================= */
/* ======================================================
    PANTALLA 1 — CONSUMO DE COMBUSTIBLE (CON SELECT)
========================================================= */
@Composable
fun CombustibleScreen(nav: NavController) {

    // Colores (no se modificaron)
    val bg = Color(0xFF0D1117)
    val card = Color(0xFF161B22)
    val accent = Color(0xFF58A6FF)

    // Estados para los TextField
    var km by remember { mutableStateOf("") }
    var litros by remember { mutableStateOf("") }

    // Estado para el resultado del consumo
    val consumo = calcularConsumo(km, litros)

    /* -------------------------------------------------------
        🔽 NUEVO: Estados del Dropdown Menu (SELECT)
       ------------------------------------------------------- */

    var expanded by remember { mutableStateOf(false) }
    // Texto que se muestra en el botón del select
    var selectedVehiculo by remember { mutableStateOf("Selecciona un vehículo") }

    /* Cómo funciona:
        expanded = true  → el menú se abre
        expanded = false → el menú se cierra
        selectedVehiculo guarda lo que eligió el usuario
    */

    Box(
        modifier = Modifier.fillMaxSize().background(bg)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            /* -------------------------------------------------------
                TARJETA PRINCIPAL
            -------------------------------------------------------- */
            Card(
                colors = CardDefaults.cardColors(card),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Text(
                        "Consumo de combustible",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = accent
                    )

                    /* -------------------------------------------------------
                        TextFields para ingreso de datos
                    -------------------------------------------------------- */
                    OutlinedTextField(
                        value = km,
                        onValueChange = { km = it },
                        label = { Text("Kilómetros recorridos") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = litros,
                        onValueChange = { litros = it },
                        label = { Text("Litros consumidos") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    /* -------------------------------------------------------
                        SELECT (DropdownMenu)
                        Aquí empieza el comboBox básico que pediste.
                    -------------------------------------------------------- */

                    Text(
                        "Tipo de vehículo:",
                        color = Color(0xFFC9D1D9),
                        fontWeight = FontWeight.SemiBold
                    )

                    Box {
                        // Botón que abre el menú
                        OutlinedButton(
                            onClick = { expanded = true },           // abre el menú
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(selectedVehiculo)                   // muestra la opción seleccionada
                        }

                        // Menú desplegable
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }  // se cierra al tocar fuera
                        ) {

                            /* Cada DropdownMenuItem es una opción */

                            DropdownMenuItem(
                                text = { Text("Auto") },
                                onClick = {
                                    selectedVehiculo = "Auto"
                                    expanded = false                 // cerrar el menú
                                }
                            )

                            DropdownMenuItem(
                                text = { Text("Moto") },
                                onClick = {
                                    selectedVehiculo = "Moto"
                                    expanded = false
                                }
                            )

                            DropdownMenuItem(
                                text = { Text("Camión") },
                                onClick = {
                                    selectedVehiculo = "Camión"
                                    expanded = false
                                }
                            )
                        }
                    }


                    if (consumo > 0)
                        Text(
                            "Consumo promedio: ${"%.2f".format(consumo)} km/L",
                            color = Color(0xFFC9D1D9)
                        )
                    else
                        Text(
                            "Ingresa datos válidos",
                            color = Color(0xFFF85149)
                        )
                }
            }

            Button(
                onClick = { nav.navigateUp() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFF58A6FF))
            ) { Text("Regresar") }
        }
    }
}

/* ======================================================
    PANTALLA 2 — COSTO DE REPARACIÓN
========================================================= */
@Composable
fun ReparacionScreen(nav: NavController) {
    val bg = Color(0xFF0D1117)
    val card = Color(0xFF161B22)
    val accent = Color(0xFF58A6FF)

    var repuestos by remember { mutableStateOf("") }
    var horas by remember { mutableStateOf("") }
    var tarifa by remember { mutableStateOf("") }

    val (costoRepuestos, manoObra, total) =
        calcularReparacion(repuestos, horas, tarifa)

    Box(
        modifier = Modifier.fillMaxSize().background(bg)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Card(
                colors = CardDefaults.cardColors(card)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        "Costo total de reparación",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = accent
                    )

                    OutlinedTextField(
                        value = repuestos,
                        onValueChange = { repuestos = it },
                        label = { Text("Costo de repuestos") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = horas,
                        onValueChange = { horas = it },
                        label = { Text("Horas de mano de obra") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = tarifa,
                        onValueChange = { tarifa = it },
                        label = { Text("Tarifa por hora") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text("Repuestos: $${"%.2f".format(costoRepuestos)}", color = Color(0xFFC9D1D9))
                    Text("Mano de obra: $${"%.2f".format(manoObra)}", color = Color(0xFFC9D1D9))
                    Text("Total: $${"%.2f".format(total)}", color = Color(0xFF4ADE80))
                }
            }

            Button(
                onClick = { nav.navigateUp() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFF58A6FF))
            ) {
                Text("Regresar")
            }
        }
    }
}

/* ======================================================
    PANTALLA 3 — HORAS FACTURABLES
========================================================= */
@Composable
fun HorasScreen(nav: NavController) {
    val bg = Color(0xFF0D1117)
    val card = Color(0xFF161B22)
    val accent = Color(0xFF58A6FF)

    var trabajos by remember { mutableStateOf("") }
    var horas by remember { mutableStateOf("") }
    var tarifa by remember { mutableStateOf("") }

    val totalHoras = horas.toDoubleOrNull() ?: 0.0
    val ingresos = totalHoras * (tarifa.toDoubleOrNull() ?: 0.0)

    Box(
        modifier = Modifier.fillMaxSize().background(bg)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Card(
                colors = CardDefaults.cardColors(card)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        "Horas facturables",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = accent
                    )

                    OutlinedTextField(
                        value = trabajos,
                        onValueChange = { trabajos = it },
                        label = { Text("Cantidad de trabajos") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = horas,
                        onValueChange = { horas = it },
                        label = { Text("Horas trabajadas") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = tarifa,
                        onValueChange = { tarifa = it },
                        label = { Text("Tarifa por hora") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text("Total horas: $totalHoras h", color = Color(0xFFC9D1D9))
                    Text("Ingresos día: $${"%.2f".format(ingresos)}", color = Color(0xFF4ADE80))
                }
            }

            Button(
                onClick = { nav.navigateUp() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFF58A6FF))
            ) { Text("Regresar") }
        }
    }
}

/* ------------------------------------------------------
    FUNCIONES LÓGICAS
------------------------------------------------------- */

fun calcularConsumo(km: String, litros: String): Double {
    val k = km.toDoubleOrNull() ?: return 0.0
    val l = litros.toDoubleOrNull() ?: return 0.0
    if (k <= 0 || l <= 0) return 0.0
    return k / l
}

fun calcularReparacion(repuestos: String, horas: String, tarifa: String): Triple<Double, Double, Double> {
    val r = repuestos.toDoubleOrNull() ?: 0.0
    val h = horas.toDoubleOrNull() ?: 0.0
    val t = tarifa.toDoubleOrNull() ?: 0.0

    val manoObra = h * t
    val total = r + manoObra

    return Triple(r, manoObra, total)
}

@Preview(showBackground = true)
@Composable
fun PreviewTallerPro() {
    TallerNavApp()
}
