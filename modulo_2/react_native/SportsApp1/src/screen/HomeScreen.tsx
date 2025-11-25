import React from "react";
import { View, Text, Pressable } from "react-native";
import colors from "../theme/colors";

export default function HomeScreen({ navigation }: any) {
  return (
    <View style={{ flex: 1, backgroundColor: colors.background, padding: 20 }}>
      <Text style={{ fontSize: 26, fontWeight: "bold", color: colors.primary, marginBottom: 16 }}>
        Deportes Hoy
      </Text>

      <Pressable
        onPress={() => navigation.navigate("Matches")}
        style={{ backgroundColor: colors.surface, padding: 16, borderRadius: 10, marginBottom: 12 }}
      >
        <Text style={{ color: colors.text, fontSize: 18 }}>Partidos del día</Text>
      </Pressable>

      <Pressable
        onPress={() => navigation.navigate("Table")}
        style={{ backgroundColor: colors.surface, padding: 16, borderRadius: 10, marginBottom: 12 }}
      >
        <Text style={{ color: colors.text, fontSize: 18 }}>Tabla de posiciones</Text>
      </Pressable>

      <Pressable
        onPress={() => navigation.navigate("Stats")}
        style={{ backgroundColor: colors.surface, padding: 16, borderRadius: 10 }}
      >
        <Text style={{ color: colors.text, fontSize: 18 }}>Estadísticas</Text>
      </Pressable>
    </View>
  );
}
