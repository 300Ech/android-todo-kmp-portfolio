package com.evertschavez.todoappkmp.data

import com.evertschavez.todoappkmp.data.local.TaskDao
import com.evertschavez.todoappkmp.data.local.TaskEntity
import com.evertschavez.todoappkmp.domain.Task
import com.evertschavez.todoappkmp.domain.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepositoryImpl(private val dao: TaskDao) : TaskRepository {
    override fun observeTasks(): Flow<List<Task>> =
        dao.observeTasks().map { list -> list.map { it.toDomain() } }

    override suspend fun addTask(title: String) {
        if (title.isEmpty()) return
        val formatted = title.trim().replaceFirstChar { it.uppercase() }
        val entity = TaskEntity(
            title = formatted,
            done = false,
            createdAt = currentTimeMillis(),
        )
        dao.insert(entity)
    }

    override suspend fun toggleDone(task: Task) {
        dao.update(task.toEntity().copy(done = !task.done))
    }

    override suspend fun deleteTask(task: Task) {
        dao.delete(task = task.toEntity())
    }

    override suspend fun deleteCompleted() {
        dao.deleteCompleted()
    }

}