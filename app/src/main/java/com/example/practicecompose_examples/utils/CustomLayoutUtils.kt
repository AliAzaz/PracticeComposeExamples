package com.example.practicecompose_examples.utils

import androidx.compose.animation.animatedFloat
import androidx.compose.animation.animatedValue
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.animation.FlingConfig
import androidx.compose.foundation.animation.fling
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Layout
import androidx.compose.ui.Modifier
import androidx.compose.ui.gesture.scrollorientationlocking.Orientation
import androidx.compose.ui.layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

@Composable
fun Modifier.swipeToDelete(
    constraints: Constraints,
    threshold: Float = .8f,
    onDelete: () -> Unit
): Modifier {
    val width = constraints.maxWidth

    val draggable = remember { mutableStateOf(true) }
    val deleted = remember { mutableStateOf(false) }

    val positionOffset = animatedFloat(0f)
    val collapse = remember { mutableStateOf(0) }
    val animatedCollapse = animatedValue(initVal = 0, converter = Int.VectorConverter)

    return (this + draggable(
        enabled = draggable.value,
        orientation = Orientation.Horizontal,
        onDrag = { delta ->
            positionOffset.snapTo((positionOffset.value + delta).coerceAtMost(0f))
        },
        onDragStopped = { velocity ->
            val config = FlingConfig(anchors = listOf(-width.toFloat(), 0f, width.toFloat()))
            if (positionOffset.value.absoluteValue >= threshold) {
                positionOffset.fling(velocity, config) { _, endValue, _ ->
                    if (endValue != 0f) {
                        animatedCollapse.snapTo(collapse.value)
                        animatedCollapse.animateTo(0, onEnd = { _, _ ->
                            deleted.value = true
                            draggable.value = false
                            onDelete()
                        }, anim = tween(500))
                    }
                }
            } else {
                draggable.value = true
            }
        })).then(layout { measurable, constraints ->
        val card = measurable.measure(constraints)
        positionOffset.setBounds(-width.toFloat(), width.toFloat())
        collapse.value = card.height
        val placeHeight = if (animatedCollapse.isRunning || deleted.value) {
            animatedCollapse.value
        } else {
            card.height
        }
        layout(width = constraints.maxWidth, height = constraints.maxHeight) {
            card.place(positionOffset.value.roundToInt(), 0)
        }
    })

}

@Composable
fun TitleRowBox(children: @Composable () -> Unit) {
    Layout(children = children, modifier = Modifier.height(30.dp)) { measurables, constraints ->
        val width = constraints.maxWidth / 5
        val title = measurables[0].measure(
            Constraints.fixedWidth(width * 3)
        )
        val date = measurables[1].measure(
            Constraints.fixedWidth((width * 1.5).toInt())
        )
        val goIcon = measurables[2].measure(
            Constraints.fixedWidth((width * 0.5).toInt())
        )
        layout(width = constraints.maxWidth, height = constraints.maxHeight) {
            title.place(x = 0, y = 0)
            date.place(
                x = title.width,
                y = (constraints.maxHeight - date.height) / 3
            )
            goIcon.placeRelative(
                x = title.width + date.width,
                y = (constraints.maxHeight - goIcon.height) / 3
            )
        }
    }
}