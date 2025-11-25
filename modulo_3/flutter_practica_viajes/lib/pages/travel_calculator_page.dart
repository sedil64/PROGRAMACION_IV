import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class TravelCalculatorPage extends StatefulWidget {
  const TravelCalculatorPage({super.key});

  @override
  State<TravelCalculatorPage> createState() => _TravelCalculatorPageState();
}

class _TravelCalculatorPageState extends State<TravelCalculatorPage> {
  // Inputs
  String daysText = '';
  String personsText = '';
  String priceText = '';

  String destino = 'Playa'; // Dropdown
  String alojamiento = 'Hostal'; // Radio buttons

  bool incluirTours = false;
  bool incluirSeguro = false;

  // Resultados
  double subtotal = 0;
  double recargos = 0;
  double total = 0;
  double precioPorPersona = 0;

  void calcular() {
    final dias = int.tryParse(daysText) ?? 0;
    final personas = int.tryParse(personsText) ?? 0;
    final precioBase = double.tryParse(priceText) ?? 0;

    if (dias <= 0 || personas <= 0 || precioBase <= 0) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text("Complete todos los campos con valores válidos"),
        ),
      );
      return;
    }

    // SUBTOTAL
    subtotal = dias * precioBase;

    // RECARGOS POR DESTINO
    double recargoDestino = 0;
    if (destino == 'Playa') recargoDestino = 0.10;
    if (destino == 'Montaña') recargoDestino = 0.15;
    if (destino == 'Ciudad') recargoDestino = 0.05;

    // RECARGOS POR ALOJAMIENTO
    double recargoAloj = 0;
    if (alojamiento == 'Hostal') recargoAloj = 0.05;
    if (alojamiento == 'Hotel 3★') recargoAloj = 0.15;
    if (alojamiento == 'Hotel 5★') recargoAloj = 0.30;

    // CHECKBOX
    double extraTours = incluirTours ? 0.10 : 0.0;
    double extraSeguro = incluirSeguro ? 0.05 : 0.0;

    final totalRecargos =
        subtotal * (recargoDestino + recargoAloj + extraTours + extraSeguro);

    recargos = totalRecargos;
    total = subtotal + recargos;
    precioPorPersona = total / personas;

    setState(() {});
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Cálculo de Viaje"),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => context.go('/'),
        ),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // ----------- INPUT: DÍAS -------------
            TextField(
              decoration: const InputDecoration(labelText: "Días de viaje"),
              keyboardType: TextInputType.number,
              onChanged: (v) => daysText = v,
            ),

            // ----------- INPUT: PERSONAS -------------
            TextField(
              decoration: const InputDecoration(
                labelText: "Número de personas",
              ),
              keyboardType: TextInputType.number,
              onChanged: (v) => personsText = v,
            ),

            // ----------- INPUT: PRECIO BASE -------------
            TextField(
              decoration: const InputDecoration(
                labelText: "Precio base por día",
              ),
              keyboardType: TextInputType.number,
              onChanged: (v) => priceText = v,
            ),

            const SizedBox(height: 20),

            // ----------- DROPDOWN DESTINO -------------
            const Text(
              "Destino",
              style: TextStyle(fontWeight: FontWeight.bold),
            ),
            DropdownButton(
              value: destino,
              items: const [
                DropdownMenuItem(value: 'Playa', child: Text("Playa (10%)")),
                DropdownMenuItem(
                  value: 'Montaña',
                  child: Text("Montaña (15%)"),
                ),
                DropdownMenuItem(value: 'Ciudad', child: Text("Ciudad (5%)")),
              ],
              onChanged: (v) => setState(() => destino = v!),
            ),

            const SizedBox(height: 20),

            // ----------- RADIO ALOJAMIENTO -------------
            const Text(
              "Alojamiento",
              style: TextStyle(fontWeight: FontWeight.bold),
            ),

            RadioListTile(
              title: const Text("Hostal (+5%)"),
              value: "Hostal",
              groupValue: alojamiento,
              onChanged: (v) => setState(() => alojamiento = v!),
            ),
            RadioListTile(
              title: const Text("Hotel 3★ (+15%)"),
              value: "Hotel 3★",
              groupValue: alojamiento,
              onChanged: (v) => setState(() => alojamiento = v!),
            ),
            RadioListTile(
              title: const Text("Hotel 5★ (+30%)"),
              value: "Hotel 5★",
              groupValue: alojamiento,
              onChanged: (v) => setState(() => alojamiento = v!),
            ),

            const SizedBox(height: 20),

            // ----------- CHECKBOX ----------------
            CheckboxListTile(
              title: const Text("Incluir tours (+10%)"),
              value: incluirTours,
              onChanged: (v) => setState(() => incluirTours = v!),
            ),
            CheckboxListTile(
              title: const Text("Incluir seguro (+5%)"),
              value: incluirSeguro,
              onChanged: (v) => setState(() => incluirSeguro = v!),
            ),

            const SizedBox(height: 20),

            // ----------- BOTÓN -------------
            Center(
              child: FilledButton(
                onPressed: calcular,
                child: const Text("Calcular"),
              ),
            ),

            const SizedBox(height: 25),

            // ----------- RESULTADOS -------------
            const Text(
              "Resultados",
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 8),

            Text("Subtotal: \$${subtotal.toStringAsFixed(2)}"),
            Text("Recargos totales: \$${recargos.toStringAsFixed(2)}"),
            Text("Total a pagar: \$${total.toStringAsFixed(2)}"),
            Text(
              "Precio por persona: \$${precioPorPersona.toStringAsFixed(2)}",
            ),
          ],
        ),
      ),
    );
  }
}
