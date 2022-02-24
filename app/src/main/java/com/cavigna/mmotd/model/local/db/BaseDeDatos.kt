package com.cavigna.mmotd.model.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cavigna.mmotd.model.models.Game
import com.cavigna.mmotd.model.models.GameDetail
import com.cavigna.mmotd.utils.Converters

@TypeConverters(Converters::class)
@Database(entities = [Game::class, GameDetail::class], version = 1)
abstract class BaseDeDatos : RoomDatabase(){
    abstract val dao: GameDao
}