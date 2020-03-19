import 'package:flutter/material.dart';
import 'package:flutter_module/services/utils.dart';

class Screen1 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return WillPopScope(
      onWillPop: onWillPop,
      child: Scaffold(
        appBar: AppBar(
          title: Text('Flutter 1'),
          leading: InkWell(
            onTap: () {
//            Navigator.of(context).pop();
              onWillPop();
            },
            child: Icon(
                Icons.arrow_back
            ),
          ),
        ),
        body: Center(
          child: Column(
            children: <Widget>[
              MaterialButton(
                color: Colors.green,
                onPressed: () {
                  navigateToFlutterScreen(screenName: "screen2");
                },
                child: Text('go to Flutter2'),
              ),
              MaterialButton(
                color: Colors.green,
                onPressed: () {
                  navigateToNative("activity2");
                },
                child: Text('go to Android2'),
              ),
              Container(
                height: 200,
                child: SingleChildScrollView(
                  child: Column(
                    children: <Widget>[
                      Container(height: 50, color: Colors.red,),
                      Container(height: 50, color: Colors.blue,),
                      Container(height: 50, color: Colors.red,),
                      Container(height: 50, color: Colors.yellow,),
                      Container(height: 50, color: Colors.blue,),
                      Container(height: 50, color: Colors.red,),
                      Container(height: 50, color: Colors.red,),

                    ],
                  ),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
