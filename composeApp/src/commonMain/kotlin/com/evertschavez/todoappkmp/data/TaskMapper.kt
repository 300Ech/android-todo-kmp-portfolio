package com.evertschavez.todoappkmp.data

import com.evertschavez.todoappkmp.data.local.TaskEntity
import com.evertschavez.todoappkmp.domain.Task

fun TaskEntity.toDomain(): Task {
    return Task(
        id = id,
        title = title,
        done = done,
        createdAt = createdAt,
    )
}

fun Task.toEntity(): TaskEntity {
    return TaskEntity(
        id = id,
        title = title,
        done = done,
        createdAt = createdAt,
    )
}