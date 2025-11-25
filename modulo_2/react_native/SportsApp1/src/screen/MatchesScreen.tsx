import React from "react";
import { View, Text, FlatList } from "react-native";
import colors from "../theme/colors";

const matches = [
  { id: 1, a: "Barcelona", b: "Real Madrid", sa: 2, sb: 1 },
  { id: 2, a: "PSG", b: "Bayern", sa: 3, sb: 3 },
  { id: 3, a: "Liverpool", b: "Chelsea", sa: 1, sb: 0 },
  { id: 4, a: "Juventus", b: "Milan", sa: 0, sb: 2 },
];

export default function MatchesScreen({ navigation }: any) {
  return (
    <View style={{ flex: 1, backgroundColor: colors.background, padding: 16 }}>
      <Text style={{ fontSize: 24, fontWeight: "bold", color: colors.primary }}>
        Partidos del día
      </Text>

      <FlatList
        data={matches}
        keyExtractor={(i) => i.id.toString()}
        renderItem={({ item }) => (
          <View
            style={{
              backgroundColor: colors.surface,
              padding: 16,
              borderRadius: 10,
              marginVertical: 8,
            }}
          >
            <Text style={{ color: colors.text, fontSize: 18 }}>
              {item.a} vs {item.b}
            </Text>
            <Text style={{ color: colors.primary, fontSize: 22, fontWeight: "bold" }}>
              {item.sa} - {item.sb}
            </Text>
          </View>
        )}
      />

      <Text
        onPress={() => navigation.goBack()}
        style={{ color: colors.primary, marginTop: 20, fontSize: 18 }}
      >
        Regresar
      </Text>
    </View>
  );
}
