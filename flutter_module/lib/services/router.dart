import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_module/defaultScreen.dart';
import 'package:flutter_module/screen1.dart';
import 'package:flutter_module/screen2.dart';
import 'package:flutter_module/screen3.dart';
Route<dynamic> generateRoute(RouteSettings settings) {
  switch (settings.name) {
    case 'screen1':
      return MaterialPageRoute(builder: (context) => Screen1());
    case 'screen2':
      return MaterialPageRoute(builder: (context) => Screen2());
    case 'screen3':
      return MaterialPageRoute(builder: (context) => Screen3());
    case 'default':
      return MaterialPageRoute(builder: (context) => DefaultScreen());
    default:
      return MaterialPageRoute(
        builder: (context) => Scaffold(
          body: Center(
            child: Text('No path for ${settings.name}'),
          ),
        ),
      );
  }
}