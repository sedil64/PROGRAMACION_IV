void main() {
  int partidos = 10;
  int golesPromedio = 3;
  int i = 0;
  
  print("Goles anotados por partido:");
  while (i <= partidos) {
    i++;
    print("Partido $i con promedio $golesPromedio goles = ${i * golesPromedio} goles totales");
  }
  
  print("\nTítulos ganados por temporada:");
  int temporadas = 10;
  int titulosPorTemporada = 2;
  i = 1;
  do {
    print("Temporada $i con $titulosPorTemporada títulos = ${i * titulosPorTemporada} títulos acumulados");
    i++;
  } while(i < temporadas);
  
