import { View, Text, FlatList, TouchableOpacity } from "react-native";
import { useNavigation } from "@react-navigation/native";
import { matches } from "../services/matches.service";
import MatchCard from "../components/MatchCard";

export default function HomeScreen() {
  const nav = useNavigation();

  return (
    <View style={{ flex: 1, padding: 20 }}>
      <Text style={{ fontSize: 22, fontWeight: "700" }}>
        Resultados Deportivos ⚽
      </Text>

      <FlatList
        data={matches}
        keyExtractor={(item) => item.id}
        renderItem={({ item }) => (
          <TouchableOpacity
            onPress={() => nav.navigate("MatchDetail", { id: item.id })}
          >
            <MatchCard item={item} />
          </TouchableOpacity>
        )}
      />
    </View>
  );
}
