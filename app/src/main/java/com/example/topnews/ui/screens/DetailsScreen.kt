package com.example.topnews.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.topnews.R
import com.example.topnews.ui.News
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun DetailsScren(articles: News,navController: NavController){
    Scaffold(
        topBar = {
DetailAppBar(onBackPressed = {navController.popBackStack()})
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "DetailScreen",
                fontWeight = FontWeight.SemiBold
            )
            CoilImage(
                imageModel = articles.urlToImage,
                contentScale = ContentScale.Crop,

                )

            Text(text = articles.author?:"no avaliable")
        }


    }

}
@Composable
fun DetailAppBar(onBackPressed:()->Unit = {}){

    TopAppBar(
        title = {
            Text(text = "Detail Screen")
        }
    ,navigationIcon = { IconButton(onClick = { onBackPressed() }) {
        Icon(imageVector = Icons.Default.ArrowBack,contentDescription = "")
            
        }}
    )

}
@Preview(showBackground = true)
@Composable
fun DetailsPreview(){
    DetailsScren(
        News(
            id = 1,

            author = "clerdson juca dos santos"
        ),
        rememberNavController()
        )
}
