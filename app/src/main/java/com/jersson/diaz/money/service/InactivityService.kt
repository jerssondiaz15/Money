package com.jersson.diaz.money.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Handler

class InactivityService: Service() {

    private val handler = Handler()
    private val inactivityRunnable = Runnable {
        val logoutIntent = Intent("com.jersson.diaz.money.login.LoginActivity")
        sendBroadcast(logoutIntent)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        restartTimer()
        return START_NOT_STICKY
    }

    private fun restartTimer() {
        handler.removeCallbacks(inactivityRunnable)
        //handler.postDelayed(inactivityRunnable, 120000) // 2 minutos
        handler.postDelayed(inactivityRunnable, 500) // 2 minutos
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(inactivityRunnable)
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}