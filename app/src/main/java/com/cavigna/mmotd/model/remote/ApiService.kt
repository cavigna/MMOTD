package com.cavigna.mmotd.model.remote

import com.cavigna.mmotd.model.models.Game
import com.cavigna.mmotd.model.models.GameDetail
import retrofit2.http.GET
import retrofit2.http.Query



interface ApiService {

    //https://www.mmobomb.com/api1/games
    @GET("games")
    suspend fun fetchListOfGames(): List<Game>

    //  https://www.mmobomb.com/api1/game?id=452
    @GET("game")
    suspend fun fetchGameDetail(
        @Query(value = "id") id: Int
    ) : GameDetail
}