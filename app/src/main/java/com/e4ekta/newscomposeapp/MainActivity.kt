package com.e4ekta.newscomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.e4ekta.newscomposeapp.ui.theme.NewsComposeAppTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )

                    FirstPage()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsComposeAppTheme {
        // Greeting("Android")
        FirstPage()
    }
}

@Composable
fun FirstPage() {
    Column(
        modifier = Modifier
            .background(colorResource(R.color.login_page_bg_color))
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement =  Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                "Login page", style = androidx.compose.ui.text.TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    lineHeight = 30.sp,
                    letterSpacing = 0.5.sp
                )
            )
            //   Spacer(modifier = Modifier.height(50.dp))
            // Header image
            Image(
                painter = painterResource(id = R.drawable.baseline_home_70),
                contentDescription = "Login Header",
                modifier = Modifier.size(100.dp)
            )
            var userName by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }
            // First name edit text
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text("User Name") },
                modifier = Modifier.fillMaxWidth()
            )

            // Password edit text
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth()
            )

            Text("username text: $userName")

            // login button
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login")
            }

        }

    }

}