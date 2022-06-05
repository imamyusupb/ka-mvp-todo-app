package com.codeyuba.todoapp.screens

import com.codeyuba.todoapp.model.TaskModel

interface MainContract {

    interface Views{
        fun setupViews()
        fun setupListeners()
        fun getTask() :TaskModel
        fun addTaskToDatabase(item:TaskModel)
        fun deleteTaskFromDatabase(item:TaskModel)
        fun getAllTaskFromDatabase():List<TaskModel>
        fun addTaskToRecyclerViewList(list :ArrayList<TaskModel>)
        fun addTaskToRecyclerView(item:TaskModel)
    }

    interface Actions{
        fun initScreen()
        fun addTaskToRecyclerView()
        fun addTaskToDatabase()
        fun fetchAllDataFromDatabase()
    }
}