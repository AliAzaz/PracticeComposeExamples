package com.example.practicecompose_examples.utils

import android.text.TextUtils
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import com.example.practicecompose_examples.model.Task
import com.example.practicecompose_examples.state.AppMain

fun addTask(taskText: Task) {
    AppMain.taskList.add(Task(taskText.title, taskText.message))
}

fun isTitleExist(title: MutableState<TextFieldValue>): Boolean {
    val item = AppMain.taskList.find { it.title == title.value.text.trim() }
    return item != null
}

fun modifyTask(prvTask: Task, taskText: Task) {
    val item = AppMain.taskList.map { if (it.title == prvTask.title) taskText else it }
    AppMain.taskList = item.toMutableList()
}

fun deleteTask(task: Task) {
    AppMain.taskList.remove(task)
}

fun validateFields(
    titleText: MutableState<TextFieldValue>,
    taskText: MutableState<TextFieldValue>
): Boolean =
    !TextUtils.isEmpty(titleText.value.text.trim()) && !TextUtils.isEmpty(taskText.value.text.trim())