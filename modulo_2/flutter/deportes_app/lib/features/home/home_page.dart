import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../../core/state/app_state.dart';
import 'match.dart';
import 'matches_data.dart';

class HomePage extends StatelessWidget {
  final AppState app;

  const HomePage({super.key, required this.app});

  @override
  Widget build(BuildContext context) {
    return ListView.separated(
      padding: const EdgeInsets.all(16),
      itemCount: matches.length,
      separatorBuilder: (_, __) => const SizedBox(height: 8),
      itemBuilder: (_, index) {
        final Match match = matches[index];

        return Card(
          child: ListTile(
            title: Text("${match.teamA} vs ${match.teamB}"),
            subtitle: const Text("Toca para ver detalles"),
            trailing: Text(
              "${match.scoreA} - ${match.scoreB}",
              style: const TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            onTap: () => context.go("/home/detail/$index"),
          ),
        );
      },
    );
  }
}
