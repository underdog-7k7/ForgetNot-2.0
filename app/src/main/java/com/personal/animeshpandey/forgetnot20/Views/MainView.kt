package com.personal.animeshpandey.forgetnot20.Views

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.personal.animeshpandey.forgetnot20.ViewModel.TaskViewModel

@Composable
fun MainView(GlobalViewModel:TaskViewModel = viewModel(),
             App_Navigator:NavHostController = rememberNavController()){

    NavHost(navController = App_Navigator,
        startDestination = Screen.TaskScreen.route){

        composable(Screen.TaskScreen.route){
            //Show task view
        }

        composable(Screen.EditTaskScreen.route){
            //Show Edit Screen for that task
        }
    }
}