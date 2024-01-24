package com.example.gamesretrofit.model

data class GamesModel(
    val count: Int,
    val results: List<GameList> //los resultados están formados de items que siguen el modelo GameList

)
//cada resultado recuperado
data class GameList(
    val id: Int,
    val name:  String,
    val background_image: String
)

