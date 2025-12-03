package com.evertschavez.todoappkmp.di

import com.evertschavez.todoappkmp.data.TaskRepositoryImpl
import com.evertschavez.todoappkmp.data.local.AppDatabase
import com.evertschavez.todoappkmp.domain.TaskRepository
import com.evertschavez.todoappkmp.domain.usecase.AddTaskUseCase
import com.evertschavez.todoappkmp.domain.usecase.DeleteCompletedTasksUseCase
import com.evertschavez.todoappkmp.domain.usecase.DeleteTaskUseCase
import com.evertschavez.todoappkmp.domain.usecase.ObserveTasksUseCase
import com.evertschavez.todoappkmp.domain.usecase.ToggleTaskDoneUseCase
import com.evertschavez.todoappkmp.ui.MainViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

internal fun appModule(database: AppDatabase) = module {
    single { database.taskDao() }

    singleOf(::TaskRepositoryImpl) { bind<TaskRepository>() }

    single { ObserveTasksUseCase(repository = get()) }
    single { AddTaskUseCase(repository = get()) }
    single { ToggleTaskDoneUseCase(repository = get()) }
    single { DeleteTaskUseCase(taskRepository = get()) }
    single { DeleteCompletedTasksUseCase(repository = get()) }

    viewModel {
        MainViewModel(
            observeTasksUseCase = get(),
            addTaskUseCase = get(),
            toggleTaskDoneUseCase = get(),
            deleteTaskUseCase = get(),
            deleteCompletedTasksUseCase = get(),
        )
    }
}