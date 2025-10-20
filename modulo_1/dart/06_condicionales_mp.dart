void main() {
  String equipo = "Barcelona SC";
  
  if (equipo == "Barcelona SC"){
    print('El equipo es Barcelona SC');
  }
  
  if (equipo == "Emelec"){
    print('El equipo es Emelec');
  }
  
  if (equipo == "LDU Quito") {
    print('El equipo es LDU Quito');
  }
  
  if (equipo == "Barcelona SC"){
    print('Es el equipo amarillo');
  } else {
    print('No es Barcelona SC');
  }
  
  if (equipo == "Emelec") {
    print('Es el equipo azul');
  } else {
    print('No es Emelec');
  }
 
  int titulos = 16;
  if (titulos > 15){
    print('Tiene más de 15 títulos');
  } else if (titulos < 15){
    print('Tiene menos de 15 títulos');
  } else {
    print('Tiene exactamente 15 títulos');
  }
 
  int campeonatos = 16;
  String categoria = campeonatos >= 15 ? 'Grande del Ecuador': 'Equipo emergente';
  print(categoria);
  
  String ciudad = "Guayaquil";
  String ubicacion = ciudad == "Guayaquil" ? 'Equipo costeño': 'Equipo serrano';
  print(ubicacion);
}