package edu.iesam.examaad1eval.features.ex2.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex2.domain.Player


class PlayersConverter {
    @TypeConverter
    fun from(player: String) = Gson().fromJson(player, Player::class.java)
    @TypeConverter
    fun to(player: Player) = Gson().toJson(player, Player::class.java)
}