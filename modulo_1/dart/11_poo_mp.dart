class Jugador{
  String nombre = "";
  String posicion = "";
  Jugador({required this.nombre, this.posicion = "sin posición"});
  @override
  String toString(){
    return "$nombre - $posicion";
  }
}

class EstadisticasEquipo{
  EstadisticasEquipo();
 
  int sumarGoles(int goles1, int goles2){
    return goles1 + goles2;
  }
 
  int restarPuntos(int puntos1, int puntos2){
    return puntos1 - puntos2;
  }
 
  int multiplicarPartidos(int jornadas, int equipos){
    return jornadas * equipos;
  }
 
  double promedioGoles(int goles, int partidos){
    return goles / partidos;
  }
}

void main() {
  final Jugador damian = Jugador(nombre: "Damián Díaz", posicion: "Mediocampista");
  print(damian);
  print(damian.nombre);
  print(damian.posicion);
  
  final Jugador enner = Jugador(nombre: "Enner Valencia", posicion: "Delantero");
  print(enner);
 
  final EstadisticasEquipo stats = EstadisticasEquipo();
  print("Suma de goles: ${stats.sumarGoles(45, 38)}");
  print("Resta de puntos: ${stats.restarPuntos(75, 68)}");
  print("Multiplicar partidos: ${stats.multiplicarPartidos(30, 16)}");
  print("Promedio de goles: ${stats.promedioGoles(60, 30)}");
}