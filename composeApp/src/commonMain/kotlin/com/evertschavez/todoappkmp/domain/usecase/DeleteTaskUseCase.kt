package com.evertschavez.todoappkmp.domain.usecase

import com.evertschavez.todoappkmp.domain.Task
import com.evertschavez.todoappkmp.domain.TaskRepository

class DeleteTaskUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: Task) {
        taskRepository.deleteTask(task = task)
    }
}