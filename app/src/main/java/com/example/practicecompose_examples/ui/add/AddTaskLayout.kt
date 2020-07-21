package com.example.practicecompose_examples.ui.add

import androidx.compose.Composable
import com.example.practicecompose_examples.model.Task
import com.example.practicecompose_examples.utils.addTask

@Composable
fun AddTask() {
    addTask(Task("", ""))
//    routingActivity(MenuOptions.TaskList)
}