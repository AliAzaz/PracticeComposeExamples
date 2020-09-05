package com.example.practicecompose_examples.utils

import android.text.TextUtils
import androidx.compose.runtime.MutableState
import com.example.practicecompose_examples.model.Task
import com.example.practicecompose_examples.state.AppMain

fun addTask(taskText: Task) {
    AppMain.taskList.add(Task(taskText.title, taskText.message, taskText.date))
}

fun isTitleExist(title: MutableState<String>): Boolean {
    val item = AppMain.taskList.find { it.title == title.value.trim() }
    return item != null
}

fun modifyTask(prvTask: Task, taskText: Task) {
    val item = AppMain.taskList.map { if (it.title == prvTask.title) taskText else it }
    AppMain.taskList = item.toMutableList()
}

fun deleteTask(index: Int, task: Task) {
    AppMain.taskList.remove(task)
}

fun validateFields(
    titleText: MutableState<String>,
    taskText: MutableState<String>
): Boolean =
    !TextUtils.isEmpty(titleText.value.trim()) && !TextUtils.isEmpty(taskText.value.trim())