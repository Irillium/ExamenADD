package edu.iesam.examaad1eval.features.ex2.data

import edu.iesam.examaad1eval.features.ex2.data.local.GameDbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.domain.Game

class GameDataRepository(
    private val remote:MockEx2RemoteDataSource,
    private val local: GameDbLocalDataSource
)
    :Ex2Repository {

    override fun getGames(): List<Game> {
        val gamesLocal=local.findGames()
        if(gamesLocal.isEmpty()){
            val gamesRemote=remote.getGames()
            local.saveGames(gamesRemote)
            return local.findGames()
        }
        return gamesLocal
    }
}