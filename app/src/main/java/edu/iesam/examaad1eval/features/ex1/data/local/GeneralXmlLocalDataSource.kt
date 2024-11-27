package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class GeneralXmlLocalDataSource(private val context: Context) {
    private val sharedPref= context.getSharedPreferences("db-exam", Context.MODE_PRIVATE)

    private val gson = Gson()

    fun saveUsers(users: List<User>) {
        val usersJson = gson.toJson(users)
        sharedPref.edit().putString("user", usersJson).apply()
    }
    fun saveItems(items: List<Item>) {
        val itemsJson = gson.toJson(items)
        sharedPref.edit().putString("item", itemsJson).apply()
    }
    fun saveServices(services: List<Services>) {
        val serviceJson = gson.toJson(services)
        sharedPref.edit().putString("service", serviceJson).apply()
    }
    fun getUsers(): List<User> {
        val usersJson = sharedPref.getString("user", null)
        usersJson?.let {
            return gson.fromJson(usersJson, Array<User>::class.java).toList()
        }?:run{
            return emptyList()
        }

    }
    fun getItems(): List<Item> {
        val itemsJson = sharedPref.getString("item", null)
        itemsJson?.let {
            return gson.fromJson(itemsJson, Array<Item>::class.java).toList()
        }?:run{
            return emptyList()
        }
    }
    fun getServices(): List<Services> {
        val serviceJson = sharedPref.getString("service", null)
        serviceJson?.let {
            return gson.fromJson(serviceJson, Array<Services>::class.java).toList()
        }?:run{
            return emptyList()
        }
    }
}