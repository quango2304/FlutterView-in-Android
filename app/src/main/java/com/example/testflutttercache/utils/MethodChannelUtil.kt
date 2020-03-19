package com.example.testflutttercache.utils

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.testflutttercache.AndroidActivity1
import com.example.testflutttercache.AndroidActivity2
import com.example.testflutttercache.AndroidActivity3
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodChannel


object MethodChannelUtil {
    var finishFlutterActivityMethods = mutableListOf<() -> Unit>()

    fun register(registrar: BinaryMessenger, context: Context) {
        MethodChannel(registrar, "NavigateActivity").setMethodCallHandler { call, result ->
            if (call.method == "navigateToActivity") {
                var activityName = call.argument<String>("activityName")
                var intent = Intent(context, AndroidActivity1::class.java)
                when (activityName) {
                    "activity1" -> intent = Intent(context, AndroidActivity1::class.java)
                    "activity2" -> intent = Intent(context, AndroidActivity2::class.java)
                    "activity3" -> intent = Intent(context, AndroidActivity3::class.java)
                }
                startActivity(context,intent, null)
                result.success("Success")
            } else if (call.method == "popFlutterActivity") {
                finishFlutterActivityMethods[finishFlutterActivityMethods.size-1]()
                finishFlutterActivityMethods.removeAt(
                    finishFlutterActivityMethods.size-1)
                result.success("Success")
            }
        }
    }

    fun addFinishMethodToList(finishFlutterActivity:() -> Unit) {
        finishFlutterActivityMethods.add(finishFlutterActivity)
    }
}
