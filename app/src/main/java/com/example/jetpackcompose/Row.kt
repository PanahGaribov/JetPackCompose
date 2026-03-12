package com.example.jetpackcompose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme


@Composable
fun rowExam(name : String,modifier: Modifier = Modifier){

    Row(modifier.fillMaxSize()){

        Text("Hello Android")
        Text("Hello Android")
        Text("Hello Android")

    }








}





@Preview(showBackground = true)
@Composable
fun examRowFun() {
    JetPackComposeTheme {
        rowExam("Android")
    }


}