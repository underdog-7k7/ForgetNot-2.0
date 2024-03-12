package com.personal.animeshpandey.forgetnot20.ViewModel

import android.app.ActivityManager.TaskDescription
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personal.animeshpandey.forgetnot20.Model.Graph
import com.personal.animeshpandey.forgetnot20.Model.Task
import com.personal.animeshpandey.forgetnot20.Model.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TaskViewModel(private val taskRepository: TaskRepository = Graph.task_repo):ViewModel() {
     var _TaskTitle by mutableStateOf("")
     var _TaskDescription by mutableStateOf("Description")
     var _TaskTime by mutableStateOf("00:00")
     var _TaskDate by mutableStateOf("12-12-2023")
     var _TaskPriority by mutableStateOf("High")


    fun updateTaskTitle(newTitle:String){
        _TaskTitle = newTitle
    }
    fun updateTaskDesc(newDesc:String){
        _TaskDescription = newDesc
    }

    fun updateTaskTime(newTime:String){
        _TaskTime = newTime
    }

    fun updateTaskDate(newDate:String){
        _TaskDate = newDate
    }

    fun updateTaskPriority(newPriority:String){
        _TaskPriority = newPriority
    }

    lateinit var getAllTasks: Flow<List<Task>> //promise the compiler that it will be called before any operations are done using it

    init{
        viewModelScope.launch {
            getAllTasks = taskRepository.getTasks()
        }
    }

    fun addTask(task:Task){
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.add_A_Task(task)
        }
    }

    fun getTaskByID(id:Int):Flow<Task>{
        return taskRepository.get_Individual_task(id)
    }

    fun UpdateTask(task:Task){
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.update_task(task)
        }
    }

    fun deleteTask(task:Task){
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.delete_task(task)
        }
    }


}

