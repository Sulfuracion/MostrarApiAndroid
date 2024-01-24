package com.example.gamesretrofit.data

import com.example.gamesretrofit.model.GamesModel
import com.example.gamesretrofit.model.SingleGameModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GameApi {
    @GET(ENDPOINT + API_KEY) //formamos el endpoint llamándolos con el método get
    suspend fun  getGames(): Response<GamesModel> //cómo es una consulta tenemos que
    @GET("$ENDPOINT/{id}$API_KEY")
    suspend fun getGameById(@Path(value="id")id: Int): Response<SingleGameModel>
}