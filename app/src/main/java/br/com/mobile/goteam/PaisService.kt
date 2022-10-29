package br.com.mobile.goteam

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.net.URL

object PaisService {


    /*val host = "http://192.168.50.171:5003"*/
    val host = "https://haric-lab.com"
    val TAG = "WEBSERVICE_APP_PAISES"

    fun getPaises(): List<Pais> {

        val url = "$host/paises.php"

        val json = HttpHelper.get(url)
        var paises = parseJson<List<Pais>>(json)

        return paises

    }

    fun savePais(pais: Pais) {
        var json = GsonBuilder().create().toJson(pais)
        HttpHelper.post("$host/addPais.php", json)
    }

    inline fun <reified T> parseJson(json: String): T {
        val type = object  : TypeToken<T>(){}.type

        return Gson().fromJson<T>(json, type)
    }




}