package com.codeyuba.todoapp.adapter

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.codeyuba.todoapp.R
import com.codeyuba.todoapp.listener.ItemClickListener
import com.codeyuba.todoapp.model.TaskModel

class TodoAdapter(var context :Context):RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

     var taskList = arrayListOf<TaskModel>()

    fun setItem(items: ArrayList<TaskModel>) {
        this.taskList.clear()
        this.taskList.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(model: TaskModel) {
        this.taskList.add(model)
        this.notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        taskList.removeAt(position)
        this.notifyItemRemoved(position)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_task,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TodoAdapter.ViewHolder, position: Int) {
        holder.edtText.text = taskList[position].task

    }

    override fun getItemCount()= taskList.size

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val edtText = itemView.findViewById<AppCompatTextView>(R.id.tv_task)
        val btn_delete = itemView.findViewById<AppCompatTextView>(R.id.btn_delete)
    }
}