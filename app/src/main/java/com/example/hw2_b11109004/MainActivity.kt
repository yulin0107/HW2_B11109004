package com.example.hw2_b11109004

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hw2_b11109004.ui.theme.HW2_B11109004Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HW2_B11109004Theme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "screenA") {
                    composable("screenA") { ScreenA(navController) }
                    composable("screenB/{name}/{imageName}/{description}") { backStackEntry ->
                        ScreenB(
                            name = backStackEntry.arguments?.getString("name") ?: "",
                            imageName = backStackEntry.arguments?.getString("imageName") ?: "",
                            description = backStackEntry.arguments?.getString("description") ?: "",
                            navController = navController)
                    }
                }
            }
        }
    }
}