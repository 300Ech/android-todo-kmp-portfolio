package com.evertschavez.todoappkmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.evertschavez.todoappkmp.data.local.DatabaseFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val database = DatabaseFactory(applicationContext)
            .create()
            .setDriver(BundledSQLiteDriver())
            .build()

        setContent {
            App(database = database)
        }
    }
}
