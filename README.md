# Scaffold Widgets Template

![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)

In this tutorial, we'll learn root items of Scaffold widgets in detail. This tutorial would be little bit lengthy so stay connected. We are going to follow:

* What is Scaffold
* TopApp Bar
* Floating Button
* Floating Docked Button
* Side Drawer Layout
* Bottom Bar including Bottom Navigation
* Divider
* State Management

## Scaffold
In jetpack compose implementing visual layout structure is implemented using scaffold component. This component ensures proper layout strategy for material
components includes floating button, topbar, bottombar and drawer will work together correctly. Scaffold component contains these arguments:

```sh
@Composable
fun Scaffold(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    topBar: @Composable (() -> Unit)? = null,
    bottomBar: @Composable (() -> Unit)? = null,
    floatingActionButton: @Composable (() -> Unit)? = null,
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    isFloatingActionButtonDocked: Boolean = false,
    drawerContent: @Composable (() -> Unit)? = null,
    drawerShape: Shape = MaterialTheme.shapes.large,
    drawerElevation: Dp = DrawerConstants.DefaultElevation,
    backgroundColor: Color = MaterialTheme.colors.background,
    bodyContent: @Composable (InnerPadding) -> Unit
)
```

* ***scaffoldState*** It contains the state of the screen, it's used for manual control over the drawer behavior, sizes of components, etc
* ***topBar*** top app bar of the screen
* ***bottomBar*** bottom bar of the screen
* ***floatingActionButton*** Main action button of your screen
* ***floatingActionButtonPosition*** position of the FAB on the screen. See [FabPosition] for possible options available.
* ***isFloatingActionButtonDocked*** whether [floatingActionButton] should overlap with [bottomBar] for half a height, if [bottomBar] exists.
* ***drawerContent*** content of the Drawer sheet that can be pulled from the left side (right for RTL).
* ***drawerShape*** shape of the drawer sheet (if set).
* ***drawerElevation*** drawer sheet elevation. This controls the size of the shadow below the drawer sheet (if set).
* ***bodyContent*** It contains content that shows on screen


## TopApp Bar Component
Top app bar that shows on the top of screen

```sh
@Composable
fun TopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = TopAppBarElevation
)
```

* ***title*** Title to be displayed on the TopAppBar
* ***navigationIcon*** The navigation icon displayed at the start of the TopAppBar
* ***actions*** The icons displayed at the end of the TopAppBar. The default layout here is a [Row], so icons inside will be placed horizontally.
* ***backgroundColor*** The background color for the TopAppBar
* ***contentColor*** The preferred content color provided by this TopAppBar to its children
* ***elevation*** the elevation of TopAppBar

## Floating Button Component
Action button floated on screen

```sh
@Composable
fun FloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
    backgroundColor: Color = MaterialTheme.colors.secondary,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = 6.dp,
    icon: @Composable () -> Unit
)
```

* ***modifier*** applied modifications to FAB
* ***onClick*** click event. The FAB will be disabled when it is null.
* ***shape*** The shape of this FAB
* ***backgroundColor*** The background color
* ***contentColor*** The preferred content color for content inside this FAB
* ***elevation*** The z-coordinate that controls the size of the shadow below the button
* ***icon*** the content of this FAB

## Floating Docked Button Component
Docked FAB overlap with bottomBar for half a height, if bottomBar exists. The implementation exactly same as FAB but you've to set some more arguments to achieve docked FAB.

```sh
 isFloatingActionButtonDocked = true,
 floatingActionButtonPosition = Scaffold.FabPosition.Center, // .FabPosition.End
```

These both arguments are available in scaffold composable function.

## Side Drawer Layout Component
Drawer sheet that's pulled from left side or from right if it's RTL. Its looks like side navigation drawer in native API.

```sh

```

## Bottom Bar Component
It's placed at the bottom of screen

```sh
@Composable
fun BottomAppBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    cutoutShape: Shape? = null,
    elevation: Dp = BottomAppBarElevation,
    content: @Composable RowScope.() -> Unit
)
```

### BottomNavigation
In this heading we will learn BottomNavigation. It's a type of TABs navigation architecture type of layout. BottomNavigation contains [BottomNavigationItem]
that defines single item and show in [RowScope].

```sh
@Composable
fun BottomNavigationItem(
    icon: @Composable () -> Unit,
    selected: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable () -> Unit = emptyContent(),
    alwaysShowLabels: Boolean = true,
    selectedContentColor: Color = contentColor(),
    unselectedContentColor: Color = EmphasisAmbient.current.medium.applyEmphasis(
        selectedContentColor
    )
)
```

## Divider Component
Create a thin line on the screen

```sh
@Composable
fun Divider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onSurface.copy(alpha = DividerAlpha),
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp
)
```

 * ***color*** color of the divider line
 * ***thickness*** thickness of the divider line, 1 dp is used by default
 * ***startIndent*** start offset of this line

 ## State Management


### CODE

You can follow the example code from here: [ScaffoldWidgetsTemplate](https://github.com/AliAzaz/PracticeComposeExamples/blob/ScaffoldItemsViewTemplate/app/src/main/java/com/example/practicecompose_examples/ui/ScaffoldItemsLayout.kt)

### OUTPUT
<img alt="Pic-1" src="https://github.com/AliAzaz/PracticeComposeExamples/blob/ScaffoldItemsViewTemplate/images/scaffold_items.jpg" width="1300"/>


## CONNECT👍
Medium: https://medium.com/@ali.azaz.alam

Twitter: https://twitter.com/AliAzazAlam1

Github: https://github.com/aliazaz

LinkedIn: https://www.linkedin.com/in/aliazazalam/
