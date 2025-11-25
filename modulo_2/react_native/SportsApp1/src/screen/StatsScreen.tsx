import React, { useState, useMemo } from "react";
import { View, Text, TextInput } from "react-native";
import colors from "../theme/colors";

export default function StatsScreen({ navigation }: any) {
  const [g, setG] = useState("");
  const [s, setS] = useState("");

  const eff = useMemo(() => {
    const goals = Number(g);
    const shots = Number(s);
    if (!goals || !shots) return "0";
    return ((goals / shots) * 100).toFixed(2);
  }, [g, s]);

  return (
    <View style={{ flex: 1, backgroundColor: colors.background, padding: 16 }}>
      <Text style={{ fontSize: 24, fontWeight: "bold", color: colors.primary }}>
        Estadísticas
      </Text>

      <TextInput
        placeholder="Goles"
        value={g}
        keyboardType="numeric"
        onChangeText={setG}
        style={{
          backgroundColor: colors.surface,
          padding: 12,
          marginTop: 12,
          borderRadius: 10,
          color: colors.text,
        }}
      />

      <TextInput
        placeholder="Tiros"
        value={s}
        keyboardType="numeric"
        onChangeText={setS}
        style={{
          backgroundColor: colors.surface,
          padding: 12,
          marginTop: 12,
          borderRadius: 10,
          color: colors.text,
        }}
      />

      <Text style={{ fontSize: 20, marginTop: 20, color: colors.text }}>
        Eficiencia: <Text style={{ color: colors.primary }}>{eff}%</Text>
      </Text>

      <Text
        onPress={() => navigation.goBack()}
        style={{ color: colors.primary, marginTop: 20, fontSize: 18 }}
      >
        Regresar
      </Text>
    </View>
  );
}
