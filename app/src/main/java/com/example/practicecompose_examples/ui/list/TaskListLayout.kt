package com.example.practicecompose_examples.ui.list

import androidx.compose.Composable
import androidx.ui.material.Scaffold

@Composable
fun TaskList() {
    Scaffold(
        floatingActionButton = { FabAddTask() },
        bodyContent = { ItemList() },
        bottomBar = { BottomFloatBar() },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = Scaffold.FabPosition.Center
    )
}