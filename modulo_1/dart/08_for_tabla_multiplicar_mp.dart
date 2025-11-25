void main() {
  int partidos = 10;
  double goles = 0;
  for (int i = 1; i <= partidos; i++) {
    goles += 2;
  }
  print("Los goles en $partidos partidos son $goles");
  
  String equipo = "Barcelona SC";
  int titulos = 16;
  double promedio = 0;
  for (int i = 1; i <= titulos; i++) {
    promedio += 1;
  }
  print("$equipo ha ganado $promedio títulos nacionales");
  
  int jugadores = 11;
  double totalCamisetas = 0;
  for (int i = 1; i <= jugadores; i++) {
    totalCamisetas += i;
  }
  print("El total de números de camisetas de 1 a $jugadores es $totalCamisetas");
}