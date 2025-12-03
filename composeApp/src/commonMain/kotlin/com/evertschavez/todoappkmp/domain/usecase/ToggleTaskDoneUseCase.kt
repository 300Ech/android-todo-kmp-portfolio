package com.evertschavez.todoappkmp.domain.usecase

import com.evertschavez.todoappkmp.domain.Task
import com.evertschavez.todoappkmp.domain.TaskRepository

class ToggleTaskDoneUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(task: Task) {
        repository.toggleDone(task = task)
    }
}