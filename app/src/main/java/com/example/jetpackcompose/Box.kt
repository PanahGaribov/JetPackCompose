package com.example.jetpackcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

 @Composable
  fun boxExam(name : String,modifier : Modifier){

      Column (modifier= Modifier.fillMaxSize()

         ){

              Text("JetPack Compose",
                  modifier = modifier.padding(start = 25.dp))
              Text("JetPack Compose",
                  modifier = modifier.padding(top = 45.dp, start = 35.dp) )
              Text("JetPack Compose")


      }


}



@Preview(showBackground = true)
@Composable
fun boxExame() {
    JetPackComposeTheme {
        boxExam(
            name = "hdc",
            modifier = Modifier
        )
    }
}