package com.example.practicecompose_examples.ui

/*
@Composable
fun TaskList() {
    val fabCounter = state { 0 }
    Scaffold(
        floatingActionButton = { FabBtnLayout(fabCounter) },
        bodyContent = { ItemLayout(fabCounter) },
        bottomBar = { BottomFloatBar() },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = Scaffold.FabPosition.Center
    )
}

@Composable
fun FabBtnLayout(fabCounter: MutableState<Int>) {
    FloatingActionButton(
        onClick = {
            fabCounter.value += 1
        },
        backgroundColor = colorResource(
            id = R.color.purple_200
        ),
        icon = { Icon(asset = vectorResource(id = R.drawable.ic_note_add), tint = Color.White) }
    )
}

@Composable
fun BottomFloatBar() {
    BottomAppBar(cutoutShape = CircleShape, content = {
    })
}

@Composable
fun ItemLayout(fabCounter: MutableState<Int>) {
    MaterialTheme {
        Column(modifier = Modifier.padding(20.dp).fillMaxWidth()) {
            Text(
                text = "Welcome to Scaffold Template",
                style = TextStyle(fontSize = 30.sp, textAlign = TextAlign.Center),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Fab Counter ${fabCounter.value}", style = MaterialTheme.typography.h5
            )
        }

    }
}*/
