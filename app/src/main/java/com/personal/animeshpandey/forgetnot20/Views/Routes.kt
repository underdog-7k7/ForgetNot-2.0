package com.personal.animeshpandey.forgetnot20.Views

sealed class Screen(val route:String){
    object TaskScreen: Screen("Task_Screen")
    object EditTaskScreen: Screen("Edit_Task_Screen")
}
