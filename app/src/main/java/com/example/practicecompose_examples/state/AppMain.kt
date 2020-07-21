package com.example.practicecompose_examples.state

import androidx.compose.getValue
import androidx.compose.mutableStateOf
import androidx.compose.setValue
import com.example.practicecompose_examples.model.Task
import com.example.practicecompose_examples.state.AppMain.route_screen

sealed class MenuOptions {
    object TaskList : MenuOptions()
    object AddTask : MenuOptions()
}


object AppMain {
    private var current_screen: MenuOptions = MenuOptions.TaskList
    var route_screen by mutableStateOf(current_screen)
    var taskList by mutableStateOf(mutableListOf<Task>())
}

fun routingActivity(activity: MenuOptions) {
    route_screen = activity
}

