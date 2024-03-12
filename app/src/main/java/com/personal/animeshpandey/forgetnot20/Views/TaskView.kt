package com.personal.animeshpandey.forgetnot20.Views

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.personal.animeshpandey.forgetnot20.Model.dummytasks
import com.personal.animeshpandey.forgetnot20.ViewModel.TaskViewModel

@OptIn( ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TaskView(
    Task_ViewModel:TaskViewModel,
    navcontroller:NavController)
{
    val currentcontext = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.primary)) {
        Column(modifier = Modifier.fillMaxWidth()){
            Text(text = "Itinerary", color = MaterialTheme.colorScheme.primaryContainer, fontSize = 96.sp)
            Text(text = "Plan Ahead,Stay Ahead.....", color = MaterialTheme.colorScheme.primaryContainer, fontSize = 24.sp, modifier = Modifier.padding(12.dp))
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(20.dp))

        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)){

            val tasklist = Task_ViewModel.getAllTasks.collectAsState(initial = listOf())

            
            LazyColumn(){
                items(tasklist.value,key = {task->task.ID}) { task ->
                    //for each task in the list , each will have its own dismiss state
                    val dismissstate = rememberDismissState(
                        confirmStateChange = {
                            if (it == DismissValue.DismissedToEnd || it == DismissValue.DismissedToStart) {
                                Task_ViewModel.deleteTask(task)
                            }
                            true
                        }
                    )

                    androidx.compose.material.SwipeToDismiss(
                        state = dismissstate,
                        background = {
                            val color by animateColorAsState(
                                if (dismissstate.dismissDirection
                                    == androidx.compose.material.DismissDirection.EndToStart
                                ) Color.Red else Color.Transparent,
                                label = ""
                            )

                            val alignment = Alignment.CenterEnd

                            Box(
                                Modifier
                                    .fillMaxSize()
                                    .background(color)
                                    .padding(horizontal = 20.dp),
                                contentAlignment = alignment
                            ) {
                                Icon(
                                    Icons.Default.Delete,
                                    contentDescription = "Delete Icon",
                                    tint = Color.White
                                )
                            }
                        },
                        directions = setOf(androidx.compose.material.DismissDirection.EndToStart),
                        dismissThresholds = { FractionalThreshold(1f) },
                        dismissContent = {
                            TaskItem(task = task,
                                onEdit = {
                                val id = task.ID
                                navcontroller.navigate(Screen.EditTaskScreen.route + "/$id")
                            })
                        }
                    )
                }
            }


            FloatingActionButton(
                modifier = Modifier
                    .align(alignment = Alignment.BottomEnd)
                    .padding(16.dp),
                onClick = {
                          navcontroller.navigate(Screen.EditTaskScreen.route + "/0")
                },
                backgroundColor = MaterialTheme.colorScheme.primaryContainer) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun tester2(){
}