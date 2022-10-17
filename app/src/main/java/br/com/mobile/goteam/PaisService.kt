package br.com.mobile.goteam

object PaisService {

    fun getPaises(): List<Pais> {
        var paises = mutableListOf<Pais>()

        for (i in 1..5) {
            var p = Pais()

            p.nome = "País $i"
            p.capital = "Capital  $i"
            p.continente = "Continente $i"
            p.bandeira = "https://static.todamateria.com.br/upload/ba/nd/bandeira-do-brasil-og.jpg"
            p.latittude = "-$i$i$i"
            p.longitude = "$i$i$i"
            p.populacao = "$i.1000.465"

            paises.add(p)
        }

        return paises

    }

}