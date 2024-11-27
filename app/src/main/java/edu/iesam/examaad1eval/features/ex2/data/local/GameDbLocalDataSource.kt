package edu.iesam.examaad1eval.features.ex2.data.local

import edu.iesam.examaad1eval.features.ex2.domain.Game

class GameDbLocalDataSource(private val gamesDao: GamesDao) {


     fun saveGames(games: List<Game>) {
        val gamesEntities= games.map { it.toEntity() }
        gamesDao.saveGames(*gamesEntities.toTypedArray())
    }
     fun findGames(): List<Game> {
        return gamesDao.getGames().map { it.toDomain() }
    }
}