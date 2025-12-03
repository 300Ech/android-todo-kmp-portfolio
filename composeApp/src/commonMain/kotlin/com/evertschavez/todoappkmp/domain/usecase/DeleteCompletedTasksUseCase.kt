package com.evertschavez.todoappkmp.domain.usecase

import com.evertschavez.todoappkmp.domain.TaskRepository

class DeleteCompletedTasksUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke() {
        repository.deleteCompleted()
    }
}