package com.example.practicecompose_examples.ui

import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.drawscope.Stroke
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.IconButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ArrowDropDown
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.example.practicecompose_examples.R

@Composable
fun ItemLayoutList() {
    VerticalScroller {
        Column {
            for (item in 0..3) {
                cardViewItem(item)
                Spacer(modifier = Modifier.padding(2.dp))
            }
        }
    }
}


@Composable
private fun cardViewItem(item: Int = 0) {
    val context = ContextAmbient.current
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(10.dp)
            .fillMaxWidth(),
        elevation = 3.dp,
        content = {
            Box(
                modifier = Modifier.padding(13.dp),
                children = {

                    Row(modifier = Modifier.fillMaxSize(), children = {
                        Image(
                            asset = imageResource(R.drawable.scene_01),
                            modifier = Modifier.drawBackground(
                                color = Color.Black,
                                style = Stroke(4f),
                                shape = CircleShape
                            ).preferredSize(50.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            modifier = Modifier.padding(start = 15.dp, top = 5.dp, end = 15.dp),
                            children = {
                                Text(
                                    "Davenport, California",
                                    style = MaterialTheme.typography.body1
                                )
                                Text("December 2018", style = MaterialTheme.typography.body2)
                            })

                        Box(gravity = Alignment.CenterEnd, modifier = Modifier.fillMaxSize()) {
                            IconButton(onClick = {}) {
                                Icon(asset = Icons.Filled.ArrowDropDown)
                            }
                        }


                    })

                })
        })
}