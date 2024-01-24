package com.example.gamesretrofit.util

import com.example.gamesretrofit.data.GameApi
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

class Constants {

    companion object{
        const val BASE_URL=""
    }
}

@Singleton
@Provides
fun providesGameApi(retrofit: Retrofit): GameApi {
    return  retrofit.create(GameApi::class.java)
}