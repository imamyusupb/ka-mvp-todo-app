package com.codeyuba.todoapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.codeyuba.todoapp.model.TaskModel

@Dao
interface TaskDAO {

    @Query("SELECT * FROM todo_table")
    fun getAllDataFromDatabase() :List<TaskModel>

    @Insert
    fun addTask(item:TaskModel)

    @Delete
    fun deleteTask(item: TaskModel)
}