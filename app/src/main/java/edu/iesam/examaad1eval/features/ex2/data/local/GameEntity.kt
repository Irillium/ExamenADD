package edu.iesam.examaad1eval.features.ex2.data.local

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import edu.iesam.examaad1eval.features.ex2.domain.Player

@Entity(tableName = "games")
 data class GameEntity(
    @PrimaryKey@ColumnInfo(name = "id") val id:String,
    @ColumnInfo(name = "title") val title:String,
    @Embedded(prefix = "players") val players:List<Player>
)