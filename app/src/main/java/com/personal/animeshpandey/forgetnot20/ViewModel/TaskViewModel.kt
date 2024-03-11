package com.personal.animeshpandey.forgetnot20.ViewModel

import android.app.ActivityManager.TaskDescription
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TaskViewModel:ViewModel() {
     var _TaskTitle by mutableStateOf("Some Task")
     var _TaskDescription by mutableStateOf("Description")
     var _TaskTime by mutableStateOf("00:00")
     var _TaskDate by mutableStateOf("12-12-2023")


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
}