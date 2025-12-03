package com.evertschavez.todoappkmp.data.local

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<AppDatabase> {
        val dbFilePath = NSHomeDirectory() + "/tasks.db"
        return Room.databaseBuilder<AppDatabase>(
            name = dbFilePath
        )
    }
}