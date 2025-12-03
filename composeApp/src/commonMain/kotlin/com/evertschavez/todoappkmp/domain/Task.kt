package com.evertschavez.todoappkmp.domain

data class Task(
    val id: Long,
    val title: String,
    val done: Boolean,
    val createdAt: Long,
)