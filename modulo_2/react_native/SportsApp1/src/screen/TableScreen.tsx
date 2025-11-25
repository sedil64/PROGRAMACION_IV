import React from "react";
import { View, Text } from "react-native";
import colors from "../theme/colors";

const table = [
  { team: "Barcelona", pts: 52, gf: 45, dg: 20 },
  { team: "Real Madrid", pts: 49, gf: 41, dg: 18 },
  { team: "Atlético", pts: 44, gf: 38, dg: 12 },
  { team: "Sevilla", pts: 35, gf: 29, dg: 4 },
];

export default function TableScreen({ navigation }: any) {
  return (
    <View style={{ flex: 1, backgroundColor: colors.background, padding: 16 }}>
      <Text style={{ fontSize: 24, fontWeight: "bold", color: colors.primary }}>
        Tabla de posiciones
      </Text>

      {table.map((t, i) => (
        <View
          key={i}
          style={{
            backgroundColor: colors.surface,
            padding: 16,
            borderRadius: 10,
            marginVertical: 8,
          }}
        >
          <Text style={{ color: colors.text, fontSize: 18 }}>
            {i + 1}. {t.team}
          </Text>
          <Text style={{ color: colors.primary, fontWeight: "bold" }}>
            Puntos: {t.pts} | GF: {t.gf} | DG: {t.dg}
          </Text>
        </View>
      ))}

      <Text
        onPress={() => navigation.goBack()}
        style={{ color: colors.primary, marginTop: 20, fontSize: 18 }}
      >
        Regresar
      </Text>
    </View>
  );
}
