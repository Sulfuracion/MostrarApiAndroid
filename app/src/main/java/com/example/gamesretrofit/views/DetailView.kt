package com.example.gamesretrofit.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gamesretrofit.components.CUSTOM_BLACK
import com.example.gamesretrofit.components.MainImage
import com.example.gamesretrofit.components.MainTopBar
import com.example.gamesretrofit.viewModel.GamesViewModel

@Composable
fun DetailView(viewModel: GamesViewModel, navController: NavController, id:Int){
    LaunchedEffect(Unit){
        viewModel.getGameById(id)
    }
    Scaffold(
        topBar= {
            MainTopBar(title = viewModel.state.name, showBackButton = true) {
                navController.popBackStack()
            }
        }
    ){
        ContenDetailView(pad = it, viewModel = viewModel)
    }

}


@Composable
fun ContenDetailView(pad: PaddingValues, viewModel: GamesViewModel){
    val state= viewModel.state
    Column(modifier= Modifier
        .padding(pad)
        .background(Color(CUSTOM_BLACK))
    ) {
        MainImage(image=state.background_image)
        Spacer(modifier=Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                . fillMaxWidth()
                .padding(start=20.dp, end=5.dp)
        ){
            MetaWebsite(state.website)
        }
    }
}