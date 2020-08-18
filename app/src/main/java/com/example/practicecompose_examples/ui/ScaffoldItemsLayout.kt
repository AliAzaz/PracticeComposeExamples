package com.example.practicecompose_examples.ui

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.state
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
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
    val selectedMenuItem = state { 0 }
    val menuItems = listOf(
        Pair("Home", Icons.Filled.Home),
        Pair("Contact", Icons.Filled.Phone),
        Pair("Settings", Icons.Filled.Settings)
    )

    Scaffold(
        bottomBar = {
            BottomAppBar(cutoutShape = RectangleShape, content = {
                BottomNavigation {
                    menuItems.forEachIndexed { index, item ->
                        BottomNavigationItem(
                            icon = { Icon(item.second) },
                            selected = selectedMenuItem.value == index,
                            onSelect = { selectedMenuItem.value = index },
                            label = { Text(text = item.first) },
                            selectedContentColor = Color.Magenta,
                            unselectedContentColor = Color.White
                        )
                    }
                }
            })
        },
        bodyContent = {
            Column {
                ItemLayout("BottomBar Layout")
                Text(
                    text = "${menuItems.get(selectedMenuItem.value).first} Selected",
                    style = MaterialTheme.typography.h6, modifier = Modifier.padding(20.dp)
                )
            }
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
            Column {
                Image(
                    asset = imageResource(R.drawable.scene_01),
                    modifier = Modifier
                        .fillMaxWidth()
                        .preferredHeight(150.dp)
                        .padding(0.dp, 0.dp, 0.dp, 10.dp),
                    contentScale = ContentScale.Crop
                )
                TextViewStyle(item = "Home", asset = Icons.Filled.Home)
                TextViewStyle(item = "Contact", asset = Icons.Filled.Phone)
                TextViewStyle(item = "Settings", asset = Icons.Filled.Settings)
                Divider(color = Color.LightGray, modifier = Modifier.padding(20.dp))
                Button(onClick = { drawerSetting.close() }, content = {
                    Text(text = "Close")
                }, modifier = Modifier.padding(10.dp))
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

@Composable
fun TextViewStyle(item: String, asset: VectorAsset) {
    Row(modifier = Modifier.padding(10.dp)) {
        Icon(
            asset = asset,
            modifier = Modifier.padding(0.dp, 3.dp, 5.dp, 0.dp)
        )
        Text(
            text = item,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(5.dp, 3.dp, 0.dp, 0.dp)
        )
    }
}
