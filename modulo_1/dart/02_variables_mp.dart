void main() {
  print("EQUIPOS REGISTRADOS\n");
  final equiposEcuador = crearEquiposEcuador();
  mostrarEquipos(equiposEcuador);
}

List<String> crearEquiposEcuador() {
  return [
    "Barcelona SC",
    "Liga de Quito",
    "Emelec",
    "Independiente del Valle",
    "Aucas",
    "Universidad Católica",
    "Mushuc Runa",
    "Delfín SC"
  ];
}

void mostrarEquipos(List<String> equipos) {
  for (int i = 0; i < equipos.length; i++) {
    print("${i + 1}. ${equipos[i]}");
  }
}