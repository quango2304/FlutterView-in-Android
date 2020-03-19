import 'package:flutter/material.dart';
import 'package:flutter_module/services/utils.dart';

class Screen3 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return WillPopScope(
      onWillPop: onWillPop,
      child: Scaffold(
        appBar: AppBar(
          title: Text('Flutter 3'),
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
          child: MaterialButton(
            color: Colors.green,
            onPressed: null,
            child: Text('This is last screen'),
          ),
        ),
      ),
    );
  }
}
