package com.evertschavez.todoappkmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.evertschavez.todoappkmp.data.local.DatabaseFactory

fun MainViewController() = ComposeUIViewController {
    val database = remember {
        DatabaseFactory()
            .create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    
    App(database = database)
}