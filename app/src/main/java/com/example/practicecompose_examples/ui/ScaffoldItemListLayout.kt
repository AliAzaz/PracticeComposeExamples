package com.example.practicecompose_examples.ui

import androidx.compose.foundation.Box
import androidx.compose.foundation.ClickableText
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicecompose_examples.state.MenuOptions
import com.example.practicecompose_examples.state.routingActivity

@Composable
fun AllItemList() {
    MaterialTheme {
        Column(modifier = Modifier.padding(20.dp).fillMaxWidth()) {
            Text(
                text = "Welcome to Scaffold Template",
                style = TextStyle(fontSize = 30.sp, textAlign = TextAlign.Center),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))

            val tasks = listOf(
                Pair("Fab Widget Layout", MenuOptions.FabWidget),
                Pair("FabDocked Widget Layout", MenuOptions.FabDockedWidget),
                Pair("BottomBar Widget Layout", MenuOptions.BottomBarWidget),
                Pair("TopBar Widget Layout", MenuOptions.TopBarWidget),
                Pair("Drawer Widget Layout", MenuOptions.DrawerWidget)
            )

            LazyColumnFor(items = tasks) { items ->
                Card(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(10.dp).fillParentMaxWidth(),
                    elevation = 3.dp,
                    content = {
                        Box(
                            modifier = Modifier.padding(13.dp),
                            children = {
                                ClickableText(
                                    text = AnnotatedString(text = items.first),
                                    onClick = {
                                        routingActivity(items.second)
                                    },
                                    style = MaterialTheme.typography.h6,
                                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp)
                                )
                            }
                        )
                    })
                Spacer(modifier = Modifier.height(5.dp))
            }
        }

    }
}