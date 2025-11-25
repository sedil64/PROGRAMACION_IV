import { View, Text, StyleSheet } from 'react-native';
import { useLocalSearchParams } from 'expo-router';

const matches = [
  { id: '1', teamA: 'Barcelona', teamB: 'Real Madrid', scoreA: 2, scoreB: 1 },
  { id: '2', teamA: 'Liverpool', teamB: 'Chelsea', scoreA: 1, scoreB: 1 },
  { id: '3', teamA: 'PSG', teamB: 'Lyon', scoreA: 3, scoreB: 0 },
  { id: '4', teamA: 'Bayern', teamB: 'Dortmund', scoreA: 0, scoreB: 2 },
];

export default function MatchDetail() {
  const { id } = useLocalSearchParams();
  const match = matches.find((m) => m.id === id);

  if (!match) return <Text>Partido no encontrado</Text>;

  return (
    <View style={styles.container}>
      <Text style={styles.title}>
        {match.teamA} vs {match.teamB}
      </Text>
      <Text style={styles.score}>
        {match.scoreA} - {match.scoreB}
      </Text>
      <Text style={styles.subtitle}>Detalles del partido</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 20 },
  title: { fontSize: 26, fontWeight: '700' },
  score: { fontSize: 40, fontWeight: '900', marginTop: 20 },
  subtitle: { fontSize: 16, marginTop: 20 },
});
