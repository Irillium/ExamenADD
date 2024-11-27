package edu.iesam.examaad1eval.features.ex2.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.iesam.examaad1eval.features.ex2.domain.Player


class PlayersConverter {
    @TypeConverter
    fun fromString(value: String): List<Player> {
        val type = object : TypeToken<List<Player>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromList(list: List<Player>): String? {
        val type = object : TypeToken<List<Player>>() {}.type
        return Gson().toJson(list, type)
    }
}