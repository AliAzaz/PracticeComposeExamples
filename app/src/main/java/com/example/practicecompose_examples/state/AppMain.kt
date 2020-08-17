package com.example.practicecompose_examples.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.practicecompose_examples.state.AppMain.route_screen

sealed class MenuOptions {
    object ScaffoldItemsList : MenuOptions()
    object FabWidget : MenuOptions()
    object FabDockedWidget : MenuOptions()
    object TopBarWidget : MenuOptions()
    object BottomBarWidget : MenuOptions()
    object DrawerWidget : MenuOptions()
}


object AppMain {
    private var current_screen: MenuOptions = MenuOptions.ScaffoldItemsList
    var route_screen by mutableStateOf(current_screen)
}

fun routingActivity(activity: MenuOptions) {
    route_screen = activity
}

