class Match {
  final String teamA;
  final String teamB;
  final int scoreA;
  final int scoreB;

  Match({
    required this.teamA,
    required this.teamB,
    required this.scoreA,
    required this.scoreB,
  });
}

final List<Match> matches = [
  Match(teamA: "Barcelona", teamB: "Real Madrid", scoreA: 2, scoreB: 1),
  Match(teamA: "PSG", teamB: "Bayern", scoreA: 3, scoreB: 3),
  Match(teamA: "Liverpool", teamB: "Chelsea", scoreA: 1, scoreB: 0),
];
