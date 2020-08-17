package com.example.practicecompose_examples.ui

import androidx.compose.foundation.ClickableText
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.state
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicecompose_examples.R

@Composable
fun FabWidgetBtnLayout() {
    val fabCounter = state { 0 }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { fabCounter.value += 1 },
                backgroundColor = colorResource(id = R.color.purple_200),
                icon = {
                    Icon(
                        asset = Icons.Filled.Add,
                        tint = Color.White
                    )
                }
            )
        },
        bodyContent = {
            ItemLayout("Fab Layout", fabCounter)
        }
    )
}

@Composable
fun FabDockedWidgetBtnLayout() {
    val fabCounter = state { 0 }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { fabCounter.value += 1 },
                backgroundColor = colorResource(id = R.color.purple_200),
                icon = {
                    Icon(
                        asset = vectorResource(id = R.drawable.ic_note_add),
                        tint = Color.White
                    )
                }
            )
        },
        bottomBar = { BottomAppBar(cutoutShape = CircleShape, content = {}) },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = Scaffold.FabPosition.Center,
        bodyContent = {
            ItemLayout("Fab Docked Layout", fabCounter)
        }
    )
}

@Composable
fun BottomBarWidgetLayout() {
    Scaffold(
        bottomBar = {
            BottomAppBar(cutoutShape = RectangleShape, content = {
                BottomNavigation {

                }
            })
        },
        bodyContent = {
            ItemLayout("BottomBar Layout")
        }
    )
}

@Composable
fun TopBarWidgetLayout() {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Practice TopAppBar")
            }, actions = {
                IconButton(onClick = {
                }, icon = {
                    Icon(asset = Icons.Filled.Info)
                })
            })
        },
        bodyContent = {
            ItemLayout("TopAppBar Layout")
        }
    )
}

@Composable
fun DrawerWidgetLayout() {
    val drawerSetting = rememberDrawerState(initialValue = DrawerValue.Closed)
    Scaffold(
        scaffoldState = ScaffoldState(drawerSetting),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Practice Drawer")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        drawerSetting.open()
                    }, icon = {
                        Icon(Icons.Filled.Menu)
                    })
                }
            )
        }, drawerContent = {
            LazyColumnFor(
                items = listOf("Home", "Contact", "Close Drawer"),
                modifier = Modifier.fillMaxSize()
            ) { items ->
                ClickableText(
                    text = AnnotatedString(text = items),
                    onClick = {
                        drawerSetting.close()
                    },
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }, bodyContent = {
            ItemLayout("Drawer Layout")
        })
}

@Composable
fun ItemLayout(title: String, fabCounter: MutableState<Int>? = null) {
    MaterialTheme {
        Column(modifier = Modifier.padding(20.dp).fillMaxWidth()) {
            Text(
                text = "Welcome to $title Template",
                style = TextStyle(fontSize = 30.sp, textAlign = TextAlign.Center),
                modifier = Modifier.fillMaxWidth()
            )
            if (fabCounter == null) return@Column
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Fab Counter ${fabCounter.value}", style = MaterialTheme.typography.h5
            )
        }

    }
}
