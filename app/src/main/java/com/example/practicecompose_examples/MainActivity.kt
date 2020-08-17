package com.example.practicecompose_examples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.example.practicecompose_examples.state.AppMain
import com.example.practicecompose_examples.state.MenuOptions
import com.example.practicecompose_examples.state.routingActivity
import com.example.practicecompose_examples.ui.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TODOAppGreeting()
        }
    }

    override fun onBackPressed() {
        if (AppMain.route_screen !is MenuOptions.ScaffoldItemsList)
            routingActivity(MenuOptions.ScaffoldItemsList)
        else
            super.onBackPressed()

    }
}

@Composable
fun TODOAppGreeting() {
    MaterialTheme {
        AppContent(AppState())
    }
}


@Preview
@Composable
fun DefaultPreview() {
    TODOAppGreeting()
}

@Composable
fun AppContent(app: AppMain) {
    Crossfade(current = app.route_screen) { activity ->
        Surface(color = MaterialTheme.colors.background) {
            when (activity) {
                is MenuOptions.FabWidget -> FabWidgetBtnLayout()
                is MenuOptions.ScaffoldItemsList -> AllItemList()
                MenuOptions.FabDockedWidget -> FabDockedWidgetBtnLayout()
                MenuOptions.TopBarWidget -> TopBarWidgetLayout()
                MenuOptions.BottomBarWidget -> BottomBarWidgetLayout()
                MenuOptions.DrawerWidget -> DrawerWidgetLayout()
            }
        }

    }
}

@Composable
fun AppState(): AppMain {
    //Initialize state
    return remember { AppMain }
}