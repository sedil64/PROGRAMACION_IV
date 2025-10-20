void main() {
  print("TABLA DE POSICIONES\n");
  final tablaLocal = {
    "Barcelona SC": {"PJ": 10, "PG": 7, "PE": 2, "PP": 1, "GF": 18, "GC": 8, "PTS": 23},
    "Liga de Quito": {"PJ": 10, "PG": 6, "PE": 3, "PP": 1, "GF": 15, "GC": 7, "PTS": 21},
    "Independiente del Valle": {"PJ": 10, "PG": 5, "PE": 4, "PP": 1, "GF": 14, "GC": 6, "PTS": 19},
    "Emelec": {"PJ": 10, "PG": 5, "PE": 2, "PP": 3, "GF": 13, "GC": 10, "PTS": 17},
  };
  
  mostrarTablaPosiciones(tablaLocal);
}

void mostrarTablaPosiciones(Map<String, Map<String, int>> tabla) {
  print("Equipo                    PJ  PG  PE  PP  GF  GC  PTS\n");
  tabla.forEach((equipo, stats) {
    print("${equipo.padRight(25)} ${stats['PJ'].toString().padLeft(2)}  ${stats['PG'].toString().padLeft(2)}  ${stats['PE'].toString().padLeft(2)}  ${stats['PP'].toString().padLeft(2)}  ${stats['GF'].toString().padLeft(2)}  ${stats['GC'].toString().padLeft(2)}  ${stats['PTS'].toString().padLeft(3)}");
  });
}