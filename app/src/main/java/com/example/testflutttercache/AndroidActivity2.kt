package com.example.testflutttercache

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testflutttercache.utils.EventChannelUtil
import kotlinx.android.synthetic.main.android_activity2.*

class AndroidActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.android_activity2)
        button2.setOnClickListener{
            var i = Intent(this, MyFlutterActivity::class.java)
            startActivity(i)
            EventChannelUtil.senRouteName("screen2", "activity2")
        }
    }
}
