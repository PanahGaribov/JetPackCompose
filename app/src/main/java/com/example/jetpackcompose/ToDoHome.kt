package com.example.jetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Home() {

    LazyColumn(modifier = Modifier.fillMaxSize()) {item {

        Text("Today",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
           modifier = Modifier.padding(start = 45.dp, top = 65.dp) )

        Spacer(modifier = Modifier.height(25.dp))



        val selectTab = remember {mutableStateOf(0)}


        TabRow(selectedTabIndex = selectTab.value,
            indicator = {},
            divider = {}){

          Tab(modifier = Modifier.padding(5.dp)
              .clip(RoundedCornerShape(15.dp)).
              background(if(selectTab.value == 0) Color(0xffE6D9CB) else Color(0xffF3EFEE)),
              selected = selectTab.value == 0,
              onClick = {selectTab.value = 0},
              text = {Text("All", fontSize = 15.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.Black)})


            Tab(modifier = Modifier.padding(5.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(if (selectTab.value == 1)Color(0xffE6D9CB)else Color(0xffF3EFEE)),
                selected = selectTab.value == 1,
                onClick = {selectTab.value = 1},
                text = {Text("Active", fontSize = 15.sp, color = Color.Black)})



            Tab(modifier = Modifier.padding(5.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(if (selectTab.value == 2)Color(  0xffE6D9CB)else Color(0xffF3EFEE)),
                selected = selectTab.value == 2,
                onClick = {selectTab.value = 2},
                text = {Text("Completed", fontSize = 15.sp,
                    color = Color.Black)})



        }








    }



















    }


















}




    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun ToDoHome(){
        Home()
    }
















