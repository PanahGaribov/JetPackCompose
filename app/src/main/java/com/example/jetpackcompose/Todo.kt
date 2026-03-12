package com.example.jetpackcompose


import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.Orange
import java.nio.file.WatchEvent

@Composable
fun Todo() {


    Box(modifier = Modifier.fillMaxSize()){

      Column(modifier = Modifier.fillMaxSize()){

          Image(painter = painterResource(R.drawable.onboarding), contentDescription = null, modifier = Modifier.fillMaxSize())
      }

     Column(modifier = Modifier.fillMaxWidth(),
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally){


         Spacer(modifier = Modifier.weight(0.2f))

         Text("Pick some new habits to get started",
             fontSize = 40.sp,
             fontWeight = FontWeight.Bold,
             modifier = Modifier.padding(start = 15.dp),
             lineHeight = 45.sp)




         Spacer(modifier = Modifier.weight(0.1f))

         Image(painter = painterResource(R.drawable.frame), contentDescription = null,
             modifier = Modifier.fillMaxWidth().weight(0.5f),
             alignment = Alignment.CenterEnd,)

     }





           Button(onClick = {},
               modifier = Modifier.fillMaxWidth()
                   .align(Alignment.BottomCenter)
                   .padding(bottom = 55.dp, start = 20.dp, end = 20.dp)
                   .height(50.dp),
               colors = ButtonDefaults.buttonColors(containerColor = Color.Black,
                   contentColor = Color.White),
               shape = RoundedCornerShape(12.dp)){

               Text("Continue", fontWeight = FontWeight.Bold,
                   fontSize = 18.sp)

           }


    }










}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TodoTask(){
    Todo()
}

