package com.jersson.diaz.money

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jersson.diaz.money.navigation.NavHost
import com.jersson.diaz.money.service.InactivityService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoneyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavHost(
                finish = { finish() }
            )
        }
    }

    override fun onPause() {
        super.onPause()
        startService(Intent(this, InactivityService::class.java))
    }

    override fun onResume() {
        super.onResume()
        startService(Intent(this, InactivityService::class.java))
    }
}