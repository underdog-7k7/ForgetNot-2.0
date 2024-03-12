package com.personal.animeshpandey.forgetnot20.Views

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.personal.animeshpandey.forgetnot20.ViewModel.TaskViewModel

@Composable
fun MainView(GlobalViewModel:TaskViewModel = viewModel(),
             App_Navigator:NavHostController = rememberNavController()){

    NavHost(navController = App_Navigator,
        startDestination = Screen.TaskScreen.route){

        composable(Screen.TaskScreen.route){
            TaskView(Task_ViewModel = GlobalViewModel, navcontroller = App_Navigator)
        }

        composable(Screen.EditTaskScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                    defaultValue = 0
                    nullable = false
                }
            )
        ){
            entry->
            val id  = if(entry.arguments!=null) entry.arguments!!.getInt("id") else 0
            EditScreen(id = id, viewModel = GlobalViewModel, navcontroller = App_Navigator)
        }
    }
}