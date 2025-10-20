void main() {
  print("Tipos de variables en Dart");

  final String pokemon = "Ditto";
  //pokemon = "ute";
  print(pokemon);
  String myName = 'Francisco';
  myName = "Quistial";
  print(myName);
  const String elemento = "Fuego";
  print('elemento: $elemento');

  bool active = false;
  active = false;
  print("Es activo: $active");
  int hp = 1000;
  print("Caballos de fuerza $hp");
  List<String> abilities = ["impostor", "correlón"];
  print("habilidades $abilities");
  final sprites = <String>["src/image1.jpg", "image2"];
  print("Imagenes $sprites");

  print("Impresion en varias lineas");
  print("""
  $pokemon
  $hp
  $sprites
  $abilities
  """);
}
