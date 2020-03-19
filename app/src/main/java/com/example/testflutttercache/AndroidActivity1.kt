package com.example.testflutttercache

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testflutttercache.utils.EventChannelUtil
import com.example.testflutttercache.utils.MethodChannelUtil
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import kotlinx.android.synthetic.main.android_activity1.*


class AndroidActivity1 : AppCompatActivity() {
    lateinit var flutterEngine : FlutterEngine


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.android_activity1)

        // Instantiate a FlutterEngine.
        flutterEngine = FlutterEngine(this)

        // Start executing Dart code to pre-warm the FlutterEngine.
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )
        // Cache the FlutterEngine to be used by FlutterActivity.
        FlutterEngineCache
            .getInstance()
            .put("my_engine_id", flutterEngine)

        EventChannelUtil.register(flutterEngine.dartExecutor.binaryMessenger)
        MethodChannelUtil.register(flutterEngine.dartExecutor.binaryMessenger, this)

        button1.setOnClickListener {
            var i = Intent(this, MyFlutterActivity::class.java)
            startActivity(i)
            EventChannelUtil.senRouteName("screen1", "activity1")
        }
    }
}
