package com.example.practicecompose_examples.ui.list

import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun TaskList() {
    Scaffold(
        floatingActionButton = { FabAddTask() },
        bodyContent = { ItemList() },
        topBar = { TopBar() },
        bottomBar = { BottomFloatBar() },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    )
}