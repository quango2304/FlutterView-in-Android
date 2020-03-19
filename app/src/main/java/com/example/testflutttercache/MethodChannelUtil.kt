package com.example.testflutttercache

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MethodChannel


object MethodChannelUtil {
    var listA = mutableListOf<() -> Unit>()

    fun register(registrar: BinaryMessenger, context: Context) {
        MethodChannel(registrar, "NavigateActivity").setMethodCallHandler { call, result ->
            if (call.method == "navigateToActivity") {
                var activityName = call.argument<String>("activityName")
                var intent = Intent(context, MainActivity::class.java)
                when (activityName) {
                    "activity1" -> intent = Intent(context, MainActivity::class.java)
                    "activity2" -> intent = Intent(context, MainActivity2::class.java)
                    "activity3" -> intent = Intent(context, MainActivity3::class.java)
                }
                startActivity(context,intent, null)
                result.success("Success")
            } else if (call.method == "popFlutterActivity") {
                listA[listA.size-1]()
                listA.removeAt(listA.size-1)
                result.success("Success")
            }
        }
    }

    fun registerMethod(finishFlutterActivity:() -> Unit) {
        listA.add(finishFlutterActivity)
    }
}
