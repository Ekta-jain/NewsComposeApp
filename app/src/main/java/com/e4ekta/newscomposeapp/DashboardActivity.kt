package com.e4ekta.newscomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.e4ekta.newscomposeapp.ui.theme.NewsComposeAppTheme

class DashboardActivity : ComponentActivity() {
    val myItems = listOf("Item 1", "Item 2", "Item 3")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {   it
                    DashBoardPage()
                }
            }
        }
    }
}

@Composable
fun DashBoardPage() {
    val myItems = listOf("Item 1", "Item 2", "Item 3")
//    Column(
//        modifier = Modifier
//            .background(colorResource(R.color.login_page_bg_color))
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//    }

    Box(modifier = Modifier.fillMaxSize()) {
        ItemGridView(myItems)
        //FAB custom color
        FloatingActionButtonBottomRight(onClick = {
            // Handle FAB click
        })
    }
}

@Composable
fun FloatingActionButtonBottomRight(onClick: () -> Unit) {


        FloatingActionButton(
            onClick = onClick
        ) {
            // FAB content, e.g., an icon
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
        }

}

@Composable
fun ItemGridView(items: List<String> ) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Set the number of rows
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        items(10) { item ->
            Box(modifier = Modifier.size(100.dp,100.dp).background(Color.Red))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    NewsComposeAppTheme {
        DashBoardPage()
    }
}