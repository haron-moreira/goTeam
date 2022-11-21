package br.com.mobile.goteam

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PaisDAO {

    @Query("SELECT * FROM pais WHERE id = :id")
    fun getById(id: Long): Pais?

    @Query("SELECT * FROM pais")
    fun getAll(): List<Pais>

    @Insert
    fun insert(pais: Pais)

    @Delete
    fun delete(pais: Pais)

    @Query("DELETE FROM pais WHERE id >= 0 OR id is null")
    fun deletaLista()

}