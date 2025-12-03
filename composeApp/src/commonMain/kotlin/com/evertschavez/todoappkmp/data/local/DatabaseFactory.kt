package com.evertschavez.todoappkmp.data.local

import androidx.room.RoomDatabase

expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<AppDatabase>
}