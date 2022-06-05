package com.codeyuba.todoapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codeyuba.todoapp.dao.TaskDAO
import com.codeyuba.todoapp.model.TaskModel

@Database(entities = [TaskModel::class], version = 1)
abstract class TaskDatabase:RoomDatabase () {
    companion object {
        val DB_NAME = "todo_task"
        var instance: TaskDatabase? = null

        fun getInstance(context: Context): TaskDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, TaskDatabase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .build()
            }
            return instance as TaskDatabase
        }
    }
        abstract  fun taskDao() :TaskDAO


}