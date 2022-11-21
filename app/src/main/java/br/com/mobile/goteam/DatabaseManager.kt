package br.com.mobile.goteam

import androidx.room.Room

object DatabaseManager {

    private var dbInstance: GoTeamDatabase

    init {
        val contexto = GoTeamApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            contexto,
            GoTeamDatabase::class.java,
            "goteam.sqlite"
        ).build()
    }

    fun getPaisDAO(): PaisDAO {
        return dbInstance.paisDao()
    }

}