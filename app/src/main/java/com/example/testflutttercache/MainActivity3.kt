package com.example.testflutttercache

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        button3.setOnClickListener{
            var i = Intent(this, MyFlutterActivity::class.java)
            startActivity(i)
            EventChannelUtil.senRouteName("screen3", "activity3")
        }
    }
}
