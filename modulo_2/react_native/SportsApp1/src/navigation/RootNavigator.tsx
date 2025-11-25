import { createNativeStackNavigator } from "@react-navigation/native-stack";
import TabsNavigator from "./TabsNavigator";
import MatchDetailScreen from "../screens/MatchDetailScreen";

const Stack = createNativeStackNavigator();

export default function RootNavigator() {
  return (
    <Stack.Navigator>
      <Stack.Screen
        name="Tabs"
        component={TabsNavigator}
        options={{ headerShown: false }}
      />

      <Stack.Screen
        name="MatchDetail"
        component={MatchDetailScreen}
        options={{ title: "Detalle del Partido" }}
      />
    </Stack.Navigator>
  );
}
