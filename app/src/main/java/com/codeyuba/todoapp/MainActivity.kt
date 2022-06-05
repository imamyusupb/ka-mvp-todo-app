package com.codeyuba.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeyuba.todoapp.adapter.TodoAdapter
import com.codeyuba.todoapp.db.TaskDatabase
import com.codeyuba.todoapp.listener.ItemClickListener
import com.codeyuba.todoapp.model.TaskModel
import com.codeyuba.todoapp.screens.MainContract
import com.codeyuba.todoapp.screens.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(),MainContract.Views {

    lateinit var presenter:MainPresenter
    lateinit var mAdapter :TodoAdapter
    lateinit var db :TaskDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = TaskDatabase.getInstance(this)
        presenter = MainPresenter(this)
    }

    override fun setupViews() {
        mAdapter = TodoAdapter(this, object : ItemClickListener{
            override fun clicked(position: Int) {
                db.taskDao().deleteTask(mAdapter.taskList[position])
                mAdapter.deleteItem(position)
            }

        })

        rvTask.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = mAdapter
        }
    }

    override fun setupListeners() {
        btn_add.setOnClickListener {
            val task = edt_write_task.text.toString()
            if (task == ""){
                Toast.makeText(this,"You haven't write it, please write a task",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            else{
                presenter.addTaskToRecyclerView()
                presenter.addTaskToDatabase()
                edt_write_task.setText("")

            }
        }
    }

    override fun getTask(): TaskModel {
        return TaskModel(
            Random.nextLong(),
            edt_write_task.text.toString()
        )
    }

    override fun addTaskToDatabase(item: TaskModel){
        db.taskDao().addTask(item)
    }

    override fun deleteTaskFromDatabase(item: TaskModel) {
        db.taskDao().deleteTask(item)
    }

    override fun getAllTaskFromDatabase(): List<TaskModel> {
      return db.taskDao().getAllDataFromDatabase()
    }

    override fun addTaskToRecyclerViewList(list: ArrayList<TaskModel>) {
        mAdapter.setItem(list)
    }

    override fun addTaskToRecyclerView(item: TaskModel) {
        mAdapter.addItem(item)
    }
}