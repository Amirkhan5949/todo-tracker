package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(private val repository: TaskRepository) : ViewModel() {

    /*fun insertTask(task: Task) {
        viewModelScope.launch {
            repository.insertTask(task)
        }
    }*/

    fun insertTask(task: Task): Boolean {
        if (task.task_title.isEmpty() || task.task_description.isEmpty() || task.task_time.isEmpty() || task.task_date.isEmpty() || task.add_an_event.isEmpty()) {
            return false // Validation failed, one or more fields are empty
        }

        viewModelScope.launch {
            repository.insertTask(task)
        }

        return true // Validation successful, all fields are filled
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            repository.updateTask(task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteTask(task)
        }
    }

    fun getAllTask(): LiveData<List<Task>> {
        return repository.getAllTask()
    }
}