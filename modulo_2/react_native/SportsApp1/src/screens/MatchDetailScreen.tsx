import { View, Text } from "react-native";
import { matches } from "../services/matches.service";

export default function MatchDetailScreen({ route }) {
  const { id } = route.params;

  const match = matches.find((m) => m.id === id);

  return (
    <View style={{ flex: 1, padding: 20 }}>
      <Text style={{ fontSize: 26, fontWeight: "bold" }}>
        {match?.teamA} vs {match?.teamB}
      </Text>

      <Text style={{ fontSize: 40, fontWeight: "900", marginTop: 20 }}>
        {match?.scoreA} - {match?.scoreB}
      </Text>
    </View>
  );
}
