package com.personal.animeshpandey.forgetnot20.Model

import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskdao:TaskDAO) {
    suspend fun add_A_Task(task:Task){
        taskdao.addTask(task)
    }

    fun getTasks(): Flow<List<Task>> = taskdao.getAllTasks()

    fun get_Individual_task(id:Int): Flow<Task>{
        return taskdao.getTaskById(id)
    }

    suspend fun update_task(task:Task){
        taskdao.updateTaskDetails(task)
    }

    suspend fun delete_task(task:Task){
        taskdao.deleteTask(task)
    }
}