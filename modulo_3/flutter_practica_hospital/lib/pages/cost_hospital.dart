import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class CalculoHospitalPage extends StatefulWidget {
  const CalculoHospitalPage({super.key});

  @override
  State<CalculoHospitalPage> createState() => _CalculoHospitalPageState();
}

class _CalculoHospitalPageState extends State<CalculoHospitalPage> {
  String habitacion = 'General';
  String seguro = 'Público';

  String diasText = '';
  String costoBaseText = '';
  String resultText = '';

  void calcularCosto() {
    final dias = double.tryParse(diasText.replaceAll(',', '.')) ?? 0;
    final costoBase = double.tryParse(costoBaseText.replaceAll(',', '.')) ?? 0;

    if (dias <= 0 || costoBase <= 0) {
      setState(() {
        resultText = 'ingrese datos';
      });
      return;
    }

    // FACTOR por habitación
    double factorHabitacion = 1;
    if (habitacion == 'habitación semi Privada') factorHabitacion = 1.4;
    if (habitacion == 'habitación privada') factorHabitacion = 2.0;

    // DESCUENTOS por seguro
    double descuento = 0;
    if (seguro == 'Publico') descuento = 0.30;
    if (seguro == 'Privado') descuento = 0.50;
    if (seguro == 'No tiene seguro') descuento = 0;

    // Cálculo final
    double costoBruto = dias * costoBase * factorHabitacion;
    double costoFinal = costoBruto * (1 - descuento);

    setState(() {
      resultText =
          'Costo bruto: \$${costoBruto.toStringAsFixed(2)}\n'
          'Descuento: ${(descuento * 100).toStringAsFixed(0)}%\n'
          'Costo final: \$${costoFinal.toStringAsFixed(2)}';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Costo de hospitalizacion'),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => context.go('/'),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            const Text(
              'Cálculo de Costo',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 20),

            // SELECT 1: Habitación
            DropdownButtonFormField(
              value: habitacion,
              decoration: const InputDecoration(
                labelText: 'Tipo de habitación',
                border: OutlineInputBorder(),
              ),
              items: const [
                DropdownMenuItem(value: 'General', child: Text('General')),
                DropdownMenuItem(
                  value: 'Semi-Privada',
                  child: Text('Semi-Privada'),
                ),
                DropdownMenuItem(value: 'Privada', child: Text('Privada')),
              ],
              onChanged: (value) {
                setState(() {
                  habitacion = value!;
                });
              },
            ),

            const SizedBox(height: 16),

            // SELECT 2: Seguro
            DropdownButtonFormField(
              value: seguro,
              decoration: const InputDecoration(
                labelText: 'Seguro médico',
                border: OutlineInputBorder(),
              ),
              items: const [
                DropdownMenuItem(value: 'Público', child: Text('Público')),
                DropdownMenuItem(value: 'Privado', child: Text('Privado')),
                DropdownMenuItem(
                  value: 'Sin seguro',
                  child: Text('Sin seguro'),
                ),
              ],
              onChanged: (value) {
                setState(() {
                  seguro = value!;
                });
              },
            ),

            const SizedBox(height: 16),

            // INPUT 1: Días hospitalización
            TextField(
              decoration: const InputDecoration(
                labelText: 'Días de hospitalización',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (value) {
                diasText = value;
              },
            ),

            const SizedBox(height: 16),

            // INPUT 2: Costo diario base
            TextField(
              decoration: const InputDecoration(
                labelText: 'Costo diario base (\$)',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (value) {
                costoBaseText = value;
              },
            ),

            const SizedBox(height: 20),

            ElevatedButton(
              onPressed: calcularCosto,
              child: const Text('Calcular'),
            ),

            const SizedBox(height: 20),

            Text(resultText, style: const TextStyle(fontSize: 16)),
          ],
        ),
      ),
    );
  }
}
