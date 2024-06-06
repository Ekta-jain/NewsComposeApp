package com.e4ekta.newscomposeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.e4ekta.newscomposeapp.ui.theme.NewsComposeAppTheme


class SignupActivity : ComponentActivity() {
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

                    SignupPage()
                }

            }
        }
    }

}

@Composable
fun Greeting1(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview1() {
    NewsComposeAppTheme {
        // Greeting("Android")
        SignupPage()
    }
}



@Composable
fun SignupPage() {
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
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(rememberScrollState())
        ){

            Text(
                stringResource(R.string.text_signup), style = androidx.compose.ui.text.TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    lineHeight = 30.sp,
                    letterSpacing = 0.5.sp
                )
            )
            // Header image
            Image(
                painter = painterResource(id = R.drawable.baseline_home_70),
                contentDescription = "Login Header",
                modifier = Modifier.size(100.dp)
            )

           // var SignupFieldState by rememberSaveable { mutableStateOf(SignupFieldState("",",","","","")) }
            val signupFieldState = rememberSaveable(stateSaver = SignupFieldStateSaver) {
                mutableStateOf(SignupFieldState("","", "","",""))
            }

//            var email by rememberSaveable(saver = SignupFieldStateSaver) { mutableStateOf("") }
            // First name edit text
            OutlinedTextField(
                value = signupFieldState.value.userName,
                onValueChange = { signupFieldState.value = signupFieldState.value.copy(userName = it) },
                label = { Text("User Name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = signupFieldState.value.emailAddress,
                onValueChange = { signupFieldState.value = signupFieldState.value.copy(emailAddress = it) },
                label = { Text("Email Address") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = signupFieldState.value.mobileNo,
                onValueChange = { signupFieldState.value = signupFieldState.value.copy(mobileNo = it) },
                label = { Text("Mobile Number") },
                modifier = Modifier.fillMaxWidth()
            )

            // Password edit text
            OutlinedTextField(
                value = signupFieldState.value.password,
                onValueChange = { signupFieldState.value = signupFieldState.value.copy(userName = it) },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = signupFieldState.value.confirmPassword,
                onValueChange = { signupFieldState.value = signupFieldState.value.copy(userName = it) },
                label = { Text("Confirm Password") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = signupFieldState.value.confirmPassword,
                onValueChange = { signupFieldState.value = signupFieldState.value.copy(userName = it) },
                label = { Text("Confirm Password") },
                modifier = Modifier.fillMaxWidth()
            )


            OutlinedTextField(
                value = signupFieldState.value.confirmPassword,
                onValueChange = { signupFieldState.value = signupFieldState.value.copy(userName = it) },
                label = { Text("Confirm Password") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = signupFieldState.value.confirmPassword,
                onValueChange = { signupFieldState.value = signupFieldState.value.copy(userName = it) },
                label = { Text("Confirm Password") },
                modifier = Modifier.fillMaxWidth()
            )

            Text("username text: ${signupFieldState.value.userName}")
            val context = LocalContext.current
            // login button
            Button(
                onClick = {
                    Toast.makeText(context, signupFieldState.value.userName, Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, DashboardActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Signup")
            }

        }

    }

}

data class SignupFieldState(
    val userName: String,
    val emailAddress: String,
    val mobileNo: String,
    val password: String,
    val confirmPassword: String
)
