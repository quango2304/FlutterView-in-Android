import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_module/services/router.dart';
import 'package:flutter_module/services/navigation_service.dart';
import 'package:flutter_module/services/utils.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {

  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  StreamSubscription _timerSubscription;
  final stream = const EventChannel('navigateParams');
  String a = 'default';
  void _updateRoute(dynamic screenName) {
    List<String> a = screenName.toString().split(',');
    navigateToFlutterScreen(fromNativeActivity: a[1], screenName: a[0]);
  }


  @override
  void initState() {
    super.initState();
    _enableTimer();
  }

  void _enableTimer() {
    if (_timerSubscription == null) {
      _timerSubscription = stream.receiveBroadcastStream().listen(_updateRoute);
    }
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: 'default',
      navigatorKey: navigatorKey,
      onGenerateRoute: generateRoute,
    );
  }
}
