package com.codeyuba.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeyuba.todoapp.adapter.TodoAdapter
import com.codeyuba.todoapp.model.TaskModel
import com.codeyuba.todoapp.screens.MainContract
import com.codeyuba.todoapp.screens.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(),MainContract.Views {

    lateinit var presenter:MainPresenter
    lateinit var mAdapter :TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
    }

    override fun setupViews() {
        mAdapter = TodoAdapter(this)
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
                edt_write_task.setText("")
                Toast.makeText(this,"Task has been added",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getTask(): TaskModel {
        return TaskModel(
            Random.nextLong(),
            edt_write_task.text.toString()
        )
    }

    override fun addTaskToRecyclerViewList(list: ArrayList<TaskModel>) {
        mAdapter.setItem(list)
    }

    override fun addTaskToRecyclerView(item: TaskModel) {
        mAdapter.addItem(item)
    }
}