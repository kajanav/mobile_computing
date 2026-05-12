package com.example.login.screen

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    userDao: UserDao,
    onLogin: () -> Unit,
    onRegisterClick: () -> Unit,

    ) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginError by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray
            ),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(400.dp)

        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = "Login",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.padding(12.dp))

                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = {
                        Text(
                            text = "Email",
                            fontWeight = FontWeight.Bold
                        )
                    }
                )

                Spacer(Modifier.padding(16.dp))

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(
                            text = "Password",
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
                Spacer(Modifier.padding(12.dp))

                Button(
                    onClick = {
                        loginError = null
                        if (email.isBlank() || password.isBlank()) {
                            loginError = "Enter email and password"
                        } else {
                            scope.launch {
                                val user = userDao.login(email.trim(), password)
                                if (user != null) {
                                    onLogin()
                                } else {
                                    loginError = "Invalid email or password"
                                }
                            }
                        }
                    },
                    shape = RoundedCornerShape(12.dp), // rounded corners
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp)

                ) {
                    Text(text = "Login", color = Color.White, fontSize = 16.sp)
                }

                loginError?.let { message ->
                    Spacer(Modifier.padding(8.dp))
                    Text(
                        text = message,
                        color = Color.Red,
                        fontSize = 14.sp
                    )
                }

                TextButton(onClick = onRegisterClick) {
                    Text("Go to Register", color = Color.Blue, fontWeight = FontWeight.Bold)
                }


            }
        }
    }
}
