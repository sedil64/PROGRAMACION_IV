package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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


sealed class SportsScreen(val route: String) {
    object Home : SportsScreen("sports_home")
    object Partidos : SportsScreen("sports_partidos")
    object Tabla : SportsScreen("sports_tabla")
    object Estadisticas : SportsScreen("sports_stats")
}


class MainSportsApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { SportsNavApp() }
    }
}


@Composable
fun SportsNavApp() {
    val nav = rememberNavController()

    MaterialTheme(colorScheme = lightColorScheme()) {   // ⭐ TEMA CLARO
        Surface(Modifier.fillMaxSize()) {
            NavHost(nav, startDestination = SportsScreen.Home.route) {

                composable(SportsScreen.Home.route) { SportsHomeScreen(nav) }
                composable(SportsScreen.Partidos.route) { SportsMatchScreen(nav) }
                composable(SportsScreen.Tabla.route) { SportsTableScreen(nav) }
                composable(SportsScreen.Estadisticas.route) { SportsStatsScreen(nav) }
            }
        }
    }
}


@Composable
fun SportsHomeScreen(nav: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Deportes del día de hoy",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            "Resultados • Tabla • Estadísticas",
            color = MaterialTheme.colorScheme.secondary
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { nav.navigate(SportsScreen.Partidos.route) }
        ) { Text("Partidos de Hoy") }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { nav.navigate(SportsScreen.Tabla.route) }
        ) { Text("Tabla de Posiciones") }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { nav.navigate(SportsScreen.Estadisticas.route) }
        ) { Text("Estadísticas de Equipos") }
    }
}


data class Match(val teamA: String, val teamB: String, val scoreA: Int, val scoreB: Int)

@Composable
fun SportsMatchScreen(nav: NavController) {

    val matches = listOf(
        Match("Barcelona", "Real Madrid", 2, 1),
        Match("Liverpool", "Chelsea", 1, 0),
        Match("PSG", "Bayern", 3, 3),
        Match("Juventus", "Milan", 0, 2),
        Match("Benfica", "Porto", 2, 2),
        Match("Arsenal", "Man City", 1, 1)
    )

    Column(Modifier.fillMaxSize().padding(16.dp)) {

        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(matches) { match ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text("${match.teamA} vs ${match.teamB}",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            "${match.scoreA} - ${match.scoreB}",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineSmall
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        Button(onClick = { nav.navigateUp() }, modifier = Modifier.fillMaxWidth()) {
            Text("Regresar")
        }
    }
}


data class TeamStanding(val team: String, val points: Int, val goals: Int, val diff: Int)

@Composable
fun SportsTableScreen(nav: NavController) {

    val table = listOf(
        TeamStanding("Barcelona", 52, 45, +20),
        TeamStanding("Real Madrid", 49, 41, +18),
        TeamStanding("Atlético Madrid", 44, 38, +12),
        TeamStanding("Girona", 40, 33, +9),
        TeamStanding("Sevilla", 35, 29, +4),
        TeamStanding("Valencia", 31, 27, 0),
        TeamStanding("Betis", 28, 24, -2),
        TeamStanding("Villarreal", 25, 22, -5)
    )

    Column(
        Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            "Tabla de posiciones",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        table.forEachIndexed { index, team ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Row(
                    Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("${index + 1}. ${team.team}", fontWeight = FontWeight.Bold)
                    Text("${team.points} pts")
                    Text("GF: ${team.goals}")
                    Text("DG: ${team.diff}")
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        Button(onClick = { nav.navigateUp() }, modifier = Modifier.fillMaxWidth()) {
            Text("Regresar")
        }
    }
}


@Composable
fun SportsStatsScreen(nav: NavController) {
    var goals by remember { mutableStateOf("") }
    var shots by remember { mutableStateOf("") }

    val efficiency = calcularEficiencia(goals, shots)

    Column(
        Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(Modifier.padding(16.dp)) {

                Text(
                    "Eficiencia de Tiros",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                OutlinedTextField(
                    value = goals,
                    onValueChange = { goals = it },
                    label = { Text("Goles anotados") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = shots,
                    onValueChange = { shots = it },
                    label = { Text("Tiros totales") },
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    "Eficiencia: ${"%.2f".format(efficiency)} %",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Regresar") }
    }
}

fun calcularEficiencia(goals: String, shots: String): Double {
    val g = goals.toIntOrNull() ?: return 0.0
    val s = shots.toIntOrNull() ?: return 0.0
    if (s == 0) return 0.0
    return (g.toDouble() / s.toDouble()) * 100.0
}

@Preview(showBackground = true)
@Composable
fun PreviewSports() {
    SportsNavApp()
}
