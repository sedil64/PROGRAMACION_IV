void main() {
  print(saludarEquipo());
  print(sumarTitulos(16, 14));
  print(calcularGolesOpcional(5, 3));
  print(calcularGolesOpcional(8));
  print(presentarJugador(nombre: "Damián Díaz", equipo: "Barcelona SC"));
  print(presentarJugador(nombre: "Miller Bolaños"));
}

String saludarEquipo() => 'Bienvenidos hinchas del Barcelona SC';

int sumarTitulos(int equipo1, int equipo2) => equipo1 + equipo2;

int calcularGolesOpcional(int golesLocal, [int golesVisita = 0]) {
  return golesLocal + golesVisita;
}

String presentarJugador({required String nombre, String equipo = 'Independiente del Valle'}) {
  return '$equipo - Jugador: $nombre';
}