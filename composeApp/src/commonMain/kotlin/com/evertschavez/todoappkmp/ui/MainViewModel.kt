package com.evertschavez.todoappkmp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evertschavez.todoappkmp.domain.Task
import com.evertschavez.todoappkmp.domain.usecase.AddTaskUseCase
import com.evertschavez.todoappkmp.domain.usecase.DeleteCompletedTasksUseCase
import com.evertschavez.todoappkmp.domain.usecase.DeleteTaskUseCase
import com.evertschavez.todoappkmp.domain.usecase.ObserveTasksUseCase
import com.evertschavez.todoappkmp.domain.usecase.ToggleTaskDoneUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainViewModel(
    private val observeTasksUseCase: ObserveTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val toggleTaskDoneUseCase: ToggleTaskDoneUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val deleteCompletedTasksUseCase: DeleteCompletedTasksUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState(isLoading = true))
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        observeTasks()
    }

    private fun observeTasks() {
        viewModelScope.launch {
            observeTasksUseCase().collectLatest { list ->
                val current = _uiState.value
                val filtered = if (current.showOnlyPending) {
                    list.filter { task -> !task.done }
                } else {
                    list
                }
                _uiState.value = current.copy(
                    isLoading = false,
                    tasks = filtered
                )
            }
        }
    }

    fun onNewTaskTitleChange(text: String) {
        _uiState.value = _uiState.value.copy(newTaskTitle = text)
    }

    fun onAddTaskClick() {
        val title = _uiState.value.newTaskTitle.trim()
        viewModelScope.launch {
            addTaskUseCase(title)
            _uiState.value = _uiState.value.copy(newTaskTitle = "")
        }
    }

    fun onToggleTask(task: Task) {
        viewModelScope.launch {
            toggleTaskDoneUseCase(task)
        }
    }

    fun onDeleteTask(task: Task) {
        viewModelScope.launch {
            deleteTaskUseCase(task)
        }
    }

    fun onDeleteCompletedClick() {
        viewModelScope.launch {
            deleteCompletedTasksUseCase()
        }
    }

    fun onToggleFilterPending() {
        _uiState.value = _uiState.value.copy(
            showOnlyPending = !_uiState.value.showOnlyPending
        )
        observeTasks()
    }
}
