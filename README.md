# ListView and CardView Template with Buttons

![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)

In this tutorial, we'll follow multiple widgets including:

* What is Row
* What is Box
* What is Spacer
* Create CardView
* Create ImageButton
* How easy to manage ListView

## Row
A composable layout that aligned it's children in Horizontal Sequence. Some applied arguments on Row function:

***modifier*** The modifier to be applied to the Row.

***horizontalArrangement*** The horizontal arrangement of the layout's children.

***verticalGravity*** The vertical gravity of the layout's children.

## Box
The Box will try to be only as small as its content. However, it will allow its content to be smaller and will position the content inside, according to gravity.

## Spacer
It creates space between the layouts

## ListView
In JetpackCompose there are two approaches that are available for implementing RecyclerView or ListView.

* Manual
* AdapterList

In both of the approaches we've identify orientation whether it's Horizontal or Vertical by applying available separate widgets.

Starting from ***Manual*** approach:

```sh
//Vertical layout
ScrollableColumn(children = {
            for (x in 0..2) {
                CardViewImplementer()
                Spacer(modifier = Modifier.padding(2.dp))
            }
        })
```

```sh
//Horizontal layout
ScrollableRow(children = {
            for (x in 0..2) {
                CardViewImplementer()
                Spacer(modifier = Modifier.padding(2.dp))
            }
        })
```

***AdapterList*** approach:

```sh
//Vertical layout
LazyColumnFor(items = AppMain.taskList, itemContent = { task ->
            CardViewImplementer(task)
            Spacer(modifier = Modifier.padding(2.dp))
        })
```

```sh
//Horizontal layout
LazyRowFor(items = AppMain.taskList, itemContent = { task ->
            CardViewImplementer(task)
            Spacer(modifier = Modifier.padding(2.dp))
        })
```

### CODE

You can follow the example code from here: [CardViewTemplate](https://github.com/AliAzaz/PracticeComposeExamples/blob/CardViewTemplate/app/src/main/java/com/example/practicecompose_examples/MainActivity.kt)

### OUTPUT
<img alt="Pic-1" src="https://github.com/AliAzaz/PracticeComposeExamples/blob/CardViewTemplate/pic_card.png" width="400"/>



## CONNECT👍
Medium: https://medium.com/@ali.azaz.alam

Twitter: https://twitter.com/AliAzazAlam1

Github: https://github.com/aliazaz

LinkedIn: https://www.linkedin.com/in/aliazazalam/
