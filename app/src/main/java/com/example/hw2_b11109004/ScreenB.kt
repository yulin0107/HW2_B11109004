package com.example.hw2_b11109004

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ScreenB(name : String, imageName: String, description: String, navController: NavController){

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Text(text = "回上一頁")
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Text(
                text = name,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            val imageResourceId = context.resources.getIdentifier(imageName, "drawable", context.packageName)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(width = 5.dp, color = androidx.compose.ui.graphics.Color.LightGray)
            ) {
                if (imageResourceId != 0) {
                    Image(
                        painter = painterResource(id = imageResourceId),
                        contentDescription = "$name",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                } else {
                    Text(text = "未找到照片")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .border(width = 5.dp, color = androidx.compose.ui.graphics.Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = description,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                )
            }

            Button(
                onClick = {
                    val gmmIntentUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=$name")
                    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                    if (mapIntent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(mapIntent)
                    }
                },
                modifier = Modifier.padding(15.dp)
            ) {
                Text(text = "打開Google Map")
            }

        }
    }
}
