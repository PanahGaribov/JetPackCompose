package com.example.jetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

@Composable
fun examColumn(name : String,modifier: Modifier = Modifier){

    Column(modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Hello World")
        Text("Hello World")
        Text("Hello World")
    }



}



@Preview(showBackground = true)
@Composable
fun examColumn() {
    JetPackComposeTheme {
        examColumn("Android")
    }
}