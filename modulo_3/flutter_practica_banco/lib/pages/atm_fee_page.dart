import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class AtmFeePage extends StatefulWidget {
  const AtmFeePage({super.key});

  @override
  State<AtmFeePage> createState() => _AtmFeePageState();
}

class _AtmFeePageState extends State<AtmFeePage> {
  String licencia = 'no';
  String amountText = '';
  String resultText = '';

  void calculateAtmFee() {
    final age = int.tryParse(amountText) ?? 0;

    String message = '';

    if (age >= 18 && licencia == 'si') {
      message = 'Puede manejar';
    } else if (age < 18) {
      message = 'No puede manejar';
    } else if (licencia == 'no') {
      message = 'No puede manejar ';
    }

    setState(() {
      resultText = message;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('¿Puede manejar?'),
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
              'Saber si puede manejar',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            TextField(
              decoration: const InputDecoration(
                labelText: 'Edad',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (value) {
                amountText = value;
              },
            ),

          const SizedBox(height: 16),

          TextField(
            decoration: const InputDecoration(
              labelText: 'Tiene licencia? si o no',
              border: OutlineInputBorder(),
            ),
            onChanged: (value) {
              licencia = value.trim().toLowerCase();
            },
          ),
            const SizedBox(height: 16),

            ElevatedButton(
              onPressed: calculateAtmFee,
              child: const Text('Calcular'),
            ),

            const SizedBox(height: 16),

            Text(
              resultText,
              style: const TextStyle(fontSize: 18),
            ),
          ],
        ),
      ),
    );
  }
}
