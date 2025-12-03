package com.evertschavez.todoappkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform