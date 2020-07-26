package com.example.practicecompose_examples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.animation.Crossfade
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.tooling.preview.Preview
import com.example.practicecompose_examples.state.AppMain
import com.example.practicecompose_examples.state.MenuOptions
import com.example.practicecompose_examples.state.routingActivity
import com.example.practicecompose_examples.ui.add.AddTask
import com.example.practicecompose_examples.ui.list.TaskList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TODOAppGreeting()
        }
    }

    override fun onBackPressed() {
        if (AppMain.route_screen !is MenuOptions.TaskList)
            routingActivity(MenuOptions.TaskList)
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
//    TODOAppGreeting()
    AddTask()
}

@Composable
fun AppContent(app: AppMain) {
    Crossfade(current = app.route_screen) { activity ->
        Surface(color = MaterialTheme.colors.background) {
            when (activity) {
                is MenuOptions.AddTask -> AddTask()
                is MenuOptions.TaskList -> TaskList()
            }
        }

    }
}

@Composable
fun AppState(): AppMain {
    //Initialize state
    return remember { AppMain }
}