package com.evertschavez.todoappkmp.domain.usecase

import com.evertschavez.todoappkmp.domain.Task
import com.evertschavez.todoappkmp.domain.TaskRepository
import kotlinx.coroutines.flow.Flow

class ObserveTasksUseCase(private val repository: TaskRepository) {
    operator fun invoke(): Flow<List<Task>> = repository.observeTasks()
}