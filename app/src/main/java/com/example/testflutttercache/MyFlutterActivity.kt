package com.example.testflutttercache

import android.content.Context
import android.os.Bundle
import com.example.testflutttercache.utils.MethodChannelUtil
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache

class MyFlutterActivity: FlutterActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MethodChannelUtil.addFinishMethodToList {
            finish()
        }
    }

    override fun provideFlutterEngine(context: Context): FlutterEngine? {
        return FlutterEngineCache
            .getInstance()
            .get("my_engine_id")

    }
}