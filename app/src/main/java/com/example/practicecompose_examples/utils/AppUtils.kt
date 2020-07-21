package com.example.practicecompose_examples.utils

import com.example.practicecompose_examples.model.Task
import com.example.practicecompose_examples.state.AppMain

fun addTask(taskText: Task) {
    AppMain.taskList.add(Task(taskText.title, taskText.message))
}