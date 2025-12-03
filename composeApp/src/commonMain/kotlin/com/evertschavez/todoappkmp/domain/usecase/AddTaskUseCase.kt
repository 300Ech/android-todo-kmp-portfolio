package com.evertschavez.todoappkmp.domain.usecase

import com.evertschavez.todoappkmp.domain.TaskRepository

class AddTaskUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(title: String) {
        val trimmed = title.trim()
        if (trimmed.isEmpty()) return
        repository.addTask(trimmed.replaceFirstChar { it.uppercase() })
    }
}