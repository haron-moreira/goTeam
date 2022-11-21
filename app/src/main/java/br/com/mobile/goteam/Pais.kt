package br.com.mobile.goteam

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "pais")
class Pais : Serializable {

    @PrimaryKey
    var id: Long? = null

    var nome: String = ""
    var capital: String = ""
    var bandeira: String = ""
    var continente: String = ""
    var populacao: String = ""
    var latitude: String = ""
    var longitude: String = ""


}