package com.evertschavez.todoappkmp.domain

import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun observeTasks(): Flow<List<Task>>
    suspend fun addTask(title: String)
    suspend fun toggleDone(task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun deleteCompleted()
}