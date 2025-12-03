package com.evertschavez.todoappkmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.evertschavez.todoappkmp.data.local.AppDatabase
import com.evertschavez.todoappkmp.di.appModule
import com.evertschavez.todoappkmp.ui.MainScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App(database: AppDatabase) {
    KoinApplication(application = {
        modules(appModule(database = database))
    }) {
        MaterialTheme {
            val viewModel = koinViewModel<com.evertschavez.todoappkmp.ui.MainViewModel>()
            MainScreen(viewModel = viewModel)
        }
    }
}