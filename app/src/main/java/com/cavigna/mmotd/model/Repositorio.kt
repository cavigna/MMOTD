package com.cavigna.mmotd.model

import android.util.Log
import com.cavigna.mmotd.model.local.db.GameDao
import com.cavigna.mmotd.model.remote.ApiService
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class Repositorio @Inject constructor(
    private val api: ApiService,
    private val dao: GameDao
){
    suspend fun fetchListOfGames() = flowOf(api.fetchListOfGames())

    suspend fun selectOrFetchGames() = flow {
        val gamesDb = dao.selectAllGames()

        if (gamesDb.isEmpty()){
            val gamesApi = api.fetchListOfGames()
            emit(gamesApi)
            dao.insertGames(gamesApi)
            Log.v("repositorio", "emitido desde la API")
        }else{
            emit(gamesDb)
            Log.v("repositorio", "emitido desde la DB")
        }

    }

    suspend fun selectOrFetchGameDetail(id: Int) = flow {
        val gameDetailDb = flowOf(dao.selectGameDetail(id))

        if (gameDetailDb.firstOrNull() == null){
            val gameDetailApi = api.fetchGameDetail(id)
            emit(gameDetailApi)
            dao.insertGameDetail(gameDetailApi)
            Log.v("repositorio", "emitido desde la API")

        }else{
            emit(dao.selectGameDetail(id))
            Log.v("repositorio", "emitido desde la DB")
        }
    }
}