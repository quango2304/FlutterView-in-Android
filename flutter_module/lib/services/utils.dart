import 'package:flutter/services.dart';
import 'package:flutter_module/services/navigation_service.dart';

List<String> routeStacks = [];

Future<void> navigateToNative(String activityName) async {
  const platform = const MethodChannel('NavigateActivity');
  try {
    await platform
        .invokeMethod('navigateToActivity', {"activityName": activityName});
  } on PlatformException catch (e) {}
}

void navigateToFlutterScreen({String fromNativeActivity = '', String screenName}) {
  if (fromNativeActivity!='') {
    routeStacks.add(fromNativeActivity);
  }
  else {
    routeStacks.add('flutter');
  }
  navigatorKey.currentState
      .pushNamed(screenName);
  print('currentStacks ${routeStacks.toString()}');
}

Future<bool> onWillPop() async {
  if(routeStacks.isNotEmpty) {
    if (routeStacks[routeStacks.length - 1] == 'flutter') {
      routeStacks.removeLast();
      print('pop normallll');
      navigatorKey.currentState.pop();
    } else {
//      navigateToNative(routeStacks[routeStacks.length - 1]);

//      SystemNavigator.pop();
      const platform = const MethodChannel('NavigateActivity');
      try {
        await platform
            .invokeMethod('popFlutterActivity');
      } on PlatformException catch (e) {}
      navigatorKey.currentState.pop();
      routeStacks.removeLast();
    }
  }

  print('currentStacks ${routeStacks.toString()}');
  return false;
}
