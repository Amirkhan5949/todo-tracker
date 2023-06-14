package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemListBinding
import com.example.myapplication.model.Task

class TaskListAdapter (private val taskList: List<Task>): RecyclerView.Adapter<TaskListAdapter.TaskListAdapterView>() {
    private lateinit var binding: ItemListBinding
    class TaskListAdapterView(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : TaskListAdapterView {
        binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskListAdapterView(binding)
    }

    override fun getItemCount(): Int {
       return taskList.size
    }

    override fun onBindViewHolder(holder: TaskListAdapterView, position: Int) {
        val task = taskList[position]
        with(holder.binding) {
            title.text = task.task_title
            description.text = task.task_description
            date.text = task.task_date
            time.text = task.task_time
        }
    }
}