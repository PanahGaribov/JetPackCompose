package com.example.jetpackcompose

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme
import com.example.jetpackcompose.ui.theme.Orange
import com.example.jetpackcompose.ui.theme.Purple40
import com.example.jetpackcompose.ui.theme.Purple80


@Composable
fun imageComp(){

    var save = remember { mutableStateOf(false) }
    var heart = remember { mutableStateOf(false) }

    Scaffold(topBar = { Row(
        modifier = Modifier.fillMaxWidth()
            .background(Color.White)
            .statusBarsPadding(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,

    ) {

        Icon(
            painter = painterResource(R.drawable.camera_icon),
            contentDescription = "Icon"
        )
        Spacer(modifier = Modifier.width(90.dp))

        Text(
            text = "Instagram",
            fontSize = 40.sp,
            fontFamily = FontFamily(Font(R.font.grand_hotel, )),

        )

        Spacer(modifier = Modifier.width(50.dp))


        Icon(
            painter = painterResource(R.drawable.igtv),
            contentDescription = "IgTv"
        )

        Spacer(modifier = Modifier.width(10.dp))

        Icon(
            painter = painterResource(R.drawable.share),
            contentDescription = "Shape",
            modifier = Modifier.size(22.dp)
        )



    }}){ paddingvalues ->  Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(paddingvalues)
    ) {




        Spacer(modifier = Modifier.height(20.dp))




        LazyRow(
            modifier = Modifier.fillMaxWidth()
                .padding(PaddingValues(vertical = 10.dp)),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(drawaableList){item ->

                Column(horizontalAlignment = Alignment.CenterHorizontally){
                  Box(contentAlignment = Alignment.BottomCenter) {
                      Box(
                          modifier = Modifier
                              .size(75.dp)
                              .background(
                                  brush = Brush.sweepGradient(
                                      listOf(
                                          Color.Yellow,
                                          Color.Magenta
                                      )
                                  ), shape = CircleShape
                              ).padding(4.dp)
                      ) {

                          Image(
                              painter = painterResource(item.image),
                              contentDescription = null,
                              modifier = Modifier.fillMaxSize().clip(CircleShape),
                              contentScale = ContentScale.Crop
                          )
                      }
                      if (item.name == "Leon"){
                          Box(Modifier
                              .align(Alignment.BottomCenter)
                              .offset(y= 6.dp)
                              ){
                              Box(modifier = Modifier
                                  .background(
                                      brush = Brush.verticalGradient(listOf(Orange, Color.Red)),
                                      shape = RoundedCornerShape(4.dp)).padding(horizontal = 6.dp)){
                                  Text(text = "LIVE", color = Color.White, fontSize = 8.sp, fontWeight = FontWeight.Bold, maxLines = 1)
                              }
                          }
                      }
                  }
                     Spacer(modifier = Modifier.height(8.dp))

                     Text(text = item.name,
                         fontSize = 15.sp,
                         fontWeight = FontWeight.Bold)

                }
            }

        }



        Row(modifier = Modifier.fillMaxWidth().padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Image(painter = painterResource(postModel.image),
                contentDescription = null,
                Modifier.size(30.dp).clip(CircleShape),)

            Spacer(Modifier.width(15.dp))

            Column {
                Text(postModel.profileName, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(postModel.location, fontSize = 13.sp)
            }

            Spacer(Modifier.weight(1.5f))

            Icon(painter = painterResource(R.drawable.ic_more),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(8.dp)
                    .size(20.dp)
            )


        }


        Spacer(modifier = Modifier.size(5.dp))
        val pagerState = rememberPagerState(pageCount = {postList.size})
        Box(modifier = Modifier.fillMaxWidth().height(400.dp)) {


            HorizontalPager(state = pagerState, modifier = Modifier.fillMaxWidth()) {page ->
                Box(){

                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(postList[page]),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop,
                        )

                    }
                    Box(modifier = Modifier.fillMaxWidth().padding(top = 10.dp, end = 6.dp),) {
                        Text(
                            "${pagerState.currentPage + 1}/${postList.size}",
                            color = Color.White,
                            modifier = Modifier.align(Alignment.TopEnd)
                                .background(
                                    Color.Black.copy(alpha = 0.5f),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .padding(8.dp),

                            fontWeight = FontWeight.Bold
                        )
                    }
                }

            }
        }


        Row (modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ){

            Icon(painter = painterResource(if(heart.value)R.drawable.heart_png else R.drawable.vbbpe), contentDescription = null,
                Modifier.size(25.dp)
                .clickable(interactionSource = remember { MutableInteractionSource() },
                    indication = null, onClick = {heart.value = !heart.value}),
                tint = if(heart.value)Color.Red else Color.Black)
            Spacer(modifier = Modifier.width(15.dp))
            Icon(painter = painterResource(R.drawable.chat), contentDescription = null, Modifier.size(22.dp))
            Spacer(modifier = Modifier.width(15.dp))
            Icon(painter = painterResource(R.drawable.share), contentDescription = null, Modifier.size(22.dp))


            Spacer(modifier = Modifier.weight(0.5f))
              Row(modifier = Modifier
                  .weight(1f),
                  horizontalArrangement = Arrangement.Center,
                  verticalAlignment = Alignment.CenterVertically){

                  repeat(postList.size){iteration -> val bottom = if(pagerState.currentPage == iteration) Color.Blue else Color.LightGray

                    Box(modifier = Modifier
                        .padding(3.dp)
                        .size(7.dp)
                        .clip(CircleShape)
                        .background(bottom)){}

                  }
              }





            Spacer(modifier = Modifier.weight(1f))
            Icon(painter = painterResource(if (save.value)R.drawable.bookmark else R.drawable.shape), contentDescription = null,Modifier.size(22.dp)
                .clickable(interactionSource = remember { MutableInteractionSource() },
                indication = null, onClick = {save.value = !save.value}),
             tint = if (save.value) Color.Black else Color.Black
            )
        }


        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 3.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically){

            Image(painter = painterResource(R.drawable.friend_photo), contentDescription = null,
                Modifier
                    .size(22.dp)
                    .padding(start = 5.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text("Liked by craig_love and 44.321 others", fontSize = 15.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(start = 5.dp))
        }

        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically){

            Text("joshua_I", fontSize = 15.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 10.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text("This game in Japan amazing!! ")
        }


        Spacer(modifier = Modifier.height(15.dp))


        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(birmarketList.birDrawable),
                contentDescription = null, Modifier.size(45.dp).padding(start = 15.dp))

            Spacer(modifier = Modifier.width(15.dp))


            Column(modifier = Modifier.fillMaxWidth()){
                Text(birmarketList.birName, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(birmarketList.locationBir, fontSize = 13.sp)

            }


            Icon(painter = painterResource(R.drawable.ic_more), contentDescription = null,
                modifier = Modifier.align(Alignment.Bottom)
                    .padding(8.dp)
                    .size(20.dp))
        }




        Box(modifier = Modifier.fillMaxWidth().height(400.dp)) {
            val pagerState2 = rememberPagerState(pageCount = { postList.size })

            Spacer(modifier = Modifier.size(5.dp))

            HorizontalPager(modifier = Modifier.fillMaxWidth(), state = pagerState2) { pager ->
               
               
               Box(modifier = Modifier.fillMaxSize()){
                   Image(
                       painter = painterResource(postList[pager]),
                       contentDescription = null,
                       modifier = Modifier.fillMaxSize(),
                       contentScale = ContentScale.Crop
                   )

                   Row(
                       modifier = Modifier.fillMaxWidth().background(Color.Blue)
                           .align(Alignment.BottomCenter)
                           .padding(horizontal = 15.dp, vertical = 8.dp),
                       horizontalArrangement = Arrangement.Start,
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Text(
                           "Shop Now",
                           color = Color.White,
                           fontSize = 15.sp,
                           fontWeight = FontWeight.Bold
                       )

                       Spacer(modifier = Modifier.weight(1f))
                       Icon(modifier = Modifier.size(15.dp),
                           tint = Color.White,
                           painter = painterResource(R.drawable.share),
                           contentDescription = null)

                   }

               }
            }


            Box(modifier = Modifier.padding(top = 10.dp, end = 6.dp).fillMaxWidth()){
                Text(
                    "${pagerState2.currentPage + 1}/${postList.size}",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.TopEnd)
                        .background(Color.Black.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
                        .padding(8.dp),
                    fontWeight = FontWeight.Bold
                )

            }
        }
        Spacer(modifier = Modifier.size(8.dp))

        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 3.dp),
            horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically){

            Image(modifier = Modifier.size(22.dp).padding(start = 5.dp), contentDescription = null, painter = painterResource(R.drawable.friend_photo))
            Spacer(modifier = Modifier.width(5.dp))
            Text("Liked by craig_love and 21.010", fontWeight = FontWeight.Bold, fontSize = 15.sp,
                modifier = Modifier.padding(start = 10.dp))
        }






    }
    }



  }




val birmarketList = BirMarketDTO(R.drawable.oval,"birmarket","Sponsored")


val postList = listOf(
    R.drawable.post_photo,
    R.drawable.post_photo,
    R.drawable.post_photo,
)


val drawaableList = listOf(
    ItemDTO(R.drawable.profile_image,"My Story"),
    ItemDTO(R.drawable.friend_photo,"Leon"),
    ItemDTO(R.drawable.kieran_story,"Kieran"),
    ItemDTO(R.drawable.karenna_story,"Karenna"),
    ItemDTO(R.drawable.profile_image,"Paul"),
    ItemDTO(R.drawable.friend_photo,"Simon"),
    ItemDTO(R.drawable.karenna_story,"Lavin"),
    ItemDTO(R.drawable.kieran_story,"Jake"),
    ItemDTO(R.drawable.friend_photo,"Karen"),
)



val postModel = PostDTO(R.drawable.joshua_photo,"joshua_I","Japan,Tokyo")


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun imageCO() {
        imageComp()
}




