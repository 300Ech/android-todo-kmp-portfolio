package com.evertschavez.todoappkmp.ui

import com.evertschavez.todoappkmp.domain.Task

data class MainUiState(
    val isLoading: Boolean = false,
    val tasks: List<Task> = emptyList(),
    val newTaskTitle: String = "",
    val showOnlyPending: Boolean = false
)
