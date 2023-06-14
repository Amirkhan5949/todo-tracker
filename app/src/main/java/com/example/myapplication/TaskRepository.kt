package com.example.myapplication

import androidx.lifecycle.LiveData
import com.example.myapplication.data.TaskDao
import com.example.myapplication.model.Task
import javax.inject.Inject

class TaskRepository @Inject constructor(private val dao: TaskDao) {

    suspend fun insertTask(task: Task){
        dao.insertTask(task)
    }

    suspend fun updateTask(task: Task){
        dao.updateTask(task)
    }

    suspend fun deleteTask(task: Task){
        dao.deleteTask(task)
    }

     fun getAllTask(): LiveData<List<Task>>{
        return dao.getAllTask()
    }
}