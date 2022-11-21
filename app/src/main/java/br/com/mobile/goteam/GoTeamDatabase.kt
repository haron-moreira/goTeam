package br.com.mobile.goteam

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(
    Pais::class
), version = 1)
abstract class GoTeamDatabase : RoomDatabase() {

    abstract fun paisDao(): PaisDAO

}