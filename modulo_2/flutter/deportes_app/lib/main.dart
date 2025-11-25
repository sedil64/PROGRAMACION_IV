import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'router.dart';

import 'core/state/app_state.dart';
import 'core/theme/app_theme.dart';
import 'core/theme/theme_controller.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  final theme = ThemeController();
  await theme.load();

  final app = AppState();

  final router = buildRouter(app: app, theme: theme);

  runApp(MyApp(app: app, theme: theme, router: router));
}

class MyApp extends StatelessWidget {
  final AppState app;
  final ThemeController theme;
  final router;

  const MyApp({
    super.key,
    required this.app,
    required this.theme,
    required this.router,
  });

  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider.value(value: app),
        ChangeNotifierProvider.value(value: theme),
      ],
      child: AnimatedBuilder(
        animation: theme,
        builder: (context, _) {
          return MaterialApp.router(
            title: "Resultados Deportivos",
            theme: AppTheme.light(),
            darkTheme: AppTheme.dark(),
            themeMode: theme.mode,
            routerConfig: router,
            debugShowCheckedModeBanner: false,
          );
        },
      ),
    );
  }
}
