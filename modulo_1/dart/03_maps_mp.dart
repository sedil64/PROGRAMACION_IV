void main() {
  print("RESULTADOS DE LA FECHA\n");
  final partido1 = crearPartido("Barcelona SC", "Emelec", 2, 1);
  final partido2 = crearPartido("Liga de Quito", "Independiente del Valle", 1, 1);
  final partido3 = crearPartido("Aucas", "Universidad Católica", 3, 0);
  
  mostrarResultado(partido1);
  mostrarResultado(partido2);
  mostrarResultado(partido3);
}

Map<String, dynamic> crearPartido(String local, String visitante, int golesLocal, int golesVisitante) {
  return {
    "local": local,
    "visitante": visitante,
    "golesLocal": golesLocal,
    "golesVisitante": golesVisitante,
    "resultado": determinarResultado(golesLocal, golesVisitante)
  };
}

String determinarResultado(int golesLocal, int golesVisitante) {
  if (golesLocal > golesVisitante) {
    return "Victoria Local";
  } else if (golesLocal < golesVisitante) {
    return "Victoria Visitante";
  } else {
    return "Empate";
  }
}

void mostrarResultado(Map<String, dynamic> partido) {
  print("${partido['local']} ${partido['golesLocal']} - ${partido['golesVisitante']} ${partido['visitante']} (${partido['resultado']})");
}