package com.example.testflutttercache.utils

import android.os.Handler
import android.os.Looper
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.EventChannel


object EventChannelUtil {
    private lateinit var connectionEventChannel: EventChannel
    private lateinit var connectionStreamHandler: ConnectionStreamHandler

    fun register(registrar: BinaryMessenger) {
        connectionStreamHandler =
            ConnectionStreamHandler()
        connectionEventChannel = EventChannel(
            registrar,
            "navigateParams"
        )
        connectionEventChannel.setStreamHandler(
            connectionStreamHandler
        )
    }

    fun senRouteName(routeName: String, fromActivity: String) {
        connectionStreamHandler.sendRouteName(routeName, fromActivity)
    }

}

class ConnectionStreamHandler : EventChannel.StreamHandler {
    private var eventSink: EventChannel.EventSink? = null
    override fun onListen(argunents: Any?, sink: EventChannel.EventSink) {
        eventSink = sink
    }

    fun sendRouteName(routeName: String, fromActivity: String) {
        Handler(Looper.getMainLooper()).post {
            eventSink?.success("${routeName},${fromActivity}")
        }
    }

    override fun onCancel(p0: Any?) {
        eventSink = null
    }
}