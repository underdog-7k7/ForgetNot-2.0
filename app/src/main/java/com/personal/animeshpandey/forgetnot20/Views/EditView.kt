package com.personal.animeshpandey.forgetnot20.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.personal.animeshpandey.forgetnot20.Model.Task
import com.personal.animeshpandey.forgetnot20.ViewModel.TaskViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(id:Int,
               viewModel:TaskViewModel,
               navcontroller:NavController)
{

    val scrollstate = rememberScrollState()

    val snackMessage = remember{ mutableStateOf("") }

    val scope = rememberCoroutineScope()


    if(id!=0){
        val task = viewModel.getTaskByID(id).collectAsState(initial = Task(0,"","","","",""))
        viewModel._TaskTitle = task.value.title
        viewModel._TaskDescription = task.value.Description
        viewModel._TaskPriority=task.value.Priority
        viewModel._TaskDate = task.value.date
        viewModel._TaskTime = task.value.time
    }
    else{
        viewModel._TaskTitle = ""
        viewModel._TaskDescription =  ""
        viewModel._TaskPriority=""
        viewModel._TaskDate =""
        viewModel._TaskTime = ""
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.primaryContainer)
        .verticalScroll(scrollstate),) {

        Row(modifier = Modifier.fillMaxWidth()){
            if(id==0){
                Text(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),text = "Add Task", color = MaterialTheme.colorScheme.primary, fontSize = 48.sp)
            }else{
                Text(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),text = "Edit Task", color = MaterialTheme.colorScheme.primary, fontSize = 96.sp)
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)){
            inputBoxTitle(viewModel,{viewModel.updateTaskTitle(it)})
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(4.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)){
            inputBoxDescription(viewModel,{viewModel.updateTaskDesc(it)})
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(4.dp))


        Row(modifier = Modifier.fillMaxWidth()){
            priorityselector(viewModel = viewModel)
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(4.dp))


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), horizontalArrangement = Arrangement.Center){
            timePicker(viewModel=viewModel)
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(4.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Button(onClick =
            { /*TO ADD/EDIT AND THEN RETURN BACK TO TASK VIEW*/
                if(viewModel._TaskTitle.isNotEmpty() && viewModel._TaskDescription.isNotEmpty()){
                    if(id!=0){
                        viewModel.UpdateTask(
                            Task(
                                ID =id,
                                title = viewModel._TaskTitle.trim(),
                                Description = viewModel._TaskDescription.trim(),
                                Priority = viewModel._TaskPriority,
                                time = viewModel._TaskTime,
                                date = viewModel._TaskDate
                            )
                        )
                    }
                    else{
                        viewModel.addTask(
                            Task(
                                title = viewModel._TaskTitle.trim(),
                                Description = viewModel._TaskDescription.trim(),
                                Priority = viewModel._TaskPriority,
                                time = viewModel._TaskTime,
                                date = viewModel._TaskDate
                            )
                        )
                        snackMessage.value = "Task Added"
                    }
                }
                else{
                    snackMessage.value="Enter details for a New Task"
                }
                scope.launch { navcontroller.navigateUp() }
            }) {
                Text(text = "Submit")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun test3(){
    EditScreen(id=1,viewModel = viewModel(), navcontroller = rememberNavController())
}

