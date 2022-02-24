package com.cavigna.mmotd.model.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cavigna.mmotd.model.models.Game
import com.cavigna.mmotd.model.models.GameDetail

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(listOfGames: List<Game>)

    @Query("SELECT * FROM games_table")
    suspend fun selectAllGames(): List<Game>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameDetail(gameDetail: GameDetail)

    @Query("SELECT * FROM game_details_table WHERE id =:id")
    suspend fun selectGameDetail(id:Int): GameDetail
}