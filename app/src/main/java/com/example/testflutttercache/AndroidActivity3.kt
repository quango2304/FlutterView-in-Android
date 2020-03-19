package com.example.testflutttercache

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testflutttercache.utils.EventChannelUtil
import kotlinx.android.synthetic.main.android_activity3.*

class AndroidActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.android_activity3)

        button3.setOnClickListener{
            var i = Intent(this, MyFlutterActivity::class.java)
            startActivity(i)
            EventChannelUtil.senRouteName("screen3", "activity3")
        }
    }
}
