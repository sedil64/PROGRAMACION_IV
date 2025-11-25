import 'package:flutter/material.dart';
import 'match.dart';
import 'matches_data.dart';

class DetailPage extends StatelessWidget {
  final String id;

  const DetailPage({super.key, required this.id});

  @override
  Widget build(BuildContext context) {
    final index = int.tryParse(id) ?? 0;
    final Match match = matches[index];

    return Scaffold(
      appBar: AppBar(title: Text("${match.teamA} vs ${match.teamB}")),
      body: Center(
        child: Card(
          child: Padding(
            padding: const EdgeInsets.all(24),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                Text(
                  "${match.teamA}  ${match.scoreA} - ${match.scoreB}  ${match.teamB}",
                  style: const TextStyle(
                    fontSize: 22,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                const SizedBox(height: 20),
                const Text(
                  "Información del partido",
                  style: TextStyle(fontSize: 16),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
