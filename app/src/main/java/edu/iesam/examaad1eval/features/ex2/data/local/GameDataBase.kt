package edu.iesam.examaad1eval.features.ex2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.features.ex2.data.local.converters.PlayersConverter

@Database(entities = [GameEntity::class], version = 1, exportSchema = false)
@TypeConverters(PlayersConverter::class)
abstract class GameDataBase : RoomDatabase() {
    abstract fun gamesDao(): GamesDao
}