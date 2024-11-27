package edu.iesam.examaad1eval

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import edu.iesam.examaad1eval.features.ex1.data.GeneralDataRepository
import edu.iesam.examaad1eval.features.ex1.data.local.GeneralXmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.data.GameDataRepository
import edu.iesam.examaad1eval.features.ex2.data.local.GameDataBase
import edu.iesam.examaad1eval.features.ex2.data.local.GameDbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.local.converters.PlayersConverter
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1(){
        val remote:MockEx1RemoteDataSource=MockEx1RemoteDataSource()
        val local: GeneralXmlLocalDataSource =GeneralXmlLocalDataSource(this)
        val repository:GeneralDataRepository=GeneralDataRepository(remote,local)

        repository.getUsers()
        repository.getItems()
        repository.getServices()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2(){
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        val db: GameDataBase = Room.databaseBuilder( this, GameDataBase::class.java,"game_db")
            .fallbackToDestructiveMigration().addTypeConverter(PlayersConverter())
            .build()

        val gamesDao=db.gamesDao()

        val remote:MockEx2RemoteDataSource=MockEx2RemoteDataSource()
        val local: GameDbLocalDataSource =GameDbLocalDataSource(gamesDao)
        val repository:GameDataRepository=GameDataRepository(remote,local)

        GlobalScope.launch {
            //llamar a Room
            val games=repository.getGames()
        }
    }
}