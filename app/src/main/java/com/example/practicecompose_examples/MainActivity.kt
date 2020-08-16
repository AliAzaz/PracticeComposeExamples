package com.example.practicecompose_examples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardGreeting()
        }
    }
}

@Composable
fun CardGreeting() {
    MaterialTheme {
        ScrollableColumn(children = {
            for (x in 0..2) {
                CardViewImplementer()
                Spacer(modifier = Modifier.padding(2.dp))
            }
        })
    }
}

@Composable
fun CardViewImplementer() {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .drawShadow(5.dp), children =
            {
                Column(children = {
                    /* Image(
                         asset = imageResource(id = R.drawable.scene_01),
                         modifier = Modifier.preferredHeightIn(160.dp, 260.dp)
                             .fillMaxWidth(),
                         contentScale = ContentScale.Crop
                     )*/
                    Image(
                        asset = imageResource(R.drawable.scene_01),
                        modifier = Modifier.fillMaxWidth().preferredHeight(260.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        "A day in Shark Fin Cove",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(15.dp, 20.dp, 0.dp, 0.dp)
                    )
                    Column(
                        modifier = Modifier.padding(15.dp), children =
                        {
                            Text("Davenport, California", style = MaterialTheme.typography.body1)
                            Text("December 2018", style = MaterialTheme.typography.body2)
                            Row(modifier = Modifier.padding(0.dp, 25.dp, 0.dp, 5.dp), children = {
                                Button(
                                    onClick = {},
                                    shape = RoundedCornerShape(5.dp),
                                    modifier = Modifier.padding(5.dp),
                                    content = {
                                        Icon(asset = Icons.Filled.Check)
                                    }
                                )
                                Button(
                                    onClick = {},
                                    shape = RoundedCornerShape(5.dp),
                                    modifier = Modifier.padding(5.dp),
                                    content = {
                                        Icon(asset = Icons.Filled.ArrowForward)
                                    }
                                )
                            })
                        })
                })
            })
    }
}

@Preview
@Composable
fun DefaultPreview() {
    CardGreeting()
}