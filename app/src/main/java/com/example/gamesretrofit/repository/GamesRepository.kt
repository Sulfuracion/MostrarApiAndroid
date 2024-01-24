package com.example.gamesretrofit.repository

import com.example.gamesretrofit.data.GameApi
import com.example.gamesretrofit.model.GameList
import com.example.gamesretrofit.model.SingleGameModel
import javax.inject.Inject

// El respositorio utiliza gameApi por lo que hay que inyectar la dependencia, devuelve la lista de resultados,
// comprobamos si todo va bien, la respuesta serán los resultados en caso contrario devolvemos null

class GamesRepository @Inject constructor(private val gameApi: GameApi){
    suspend fun getGames(): List<GameList>? {
        val response=gameApi.getGames()
        if (response.isSuccessful){
            return response.body()?.results
        }
        return null
    }
}

suspend fun getGameById(id:Int): SingleGameModel?{
    val response=GameApi.getGameById(id)
    if (response.isSuccessful){
        return response.body()
    }
    return null
}