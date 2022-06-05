package com.codeyuba.todoapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class TaskModel(

    @PrimaryKey
    var key :Long,

    @ColumnInfo(name = "task")
    var task:String
)
