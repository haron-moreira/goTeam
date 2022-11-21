package br.com.mobile.goteam


import android.content.Intent
import android.net.Uri
import androidx.appcompat.widget.Toolbar
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import br.com.mobile.goteam.databinding.ActivityDetalhesBinding
import com.squareup.picasso.Picasso

class DetalhesActivity : LogActivity() {

    private val binding by lazy {
        ActivityDetalhesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val params = intent.extras
        var nome = params?.getString("nomePais")
        var capital = params?.getString("capitalPais")
        var bandeira = params?.getString("bandeiraPais")
        var continente = params?.getString("continentePais")
        var populacao = params?.getString("populacaoPais")
        var latitude = params?.getString("latitudePais")
        var longitude = params?.getString("longitudePais")
        var coordenadas = "$latitude, $longitude"

        /* var pais_detalhe = params?.getSerializable("pais") as Pais
        * binding.paisNome.text = pais_detalhe.nome */

        binding.paisCapital.text = capital
        binding.paisContinente.text = continente
        binding.paisNome.text = nome
        binding.paisPopulacao.text = populacao
        binding.paisCoordenadas.text = coordenadas

        Picasso.with(this).load(bandeira).fit().into(binding.paisImage,
            object: com.squareup.picasso.Callback{
                override fun onError() {

                }

                override fun onSuccess() {

                }
            })

        binding.button.setOnClickListener{
            val url_mapa = "https://www.google.com/maps/search/?api=1&query=$nome"

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url_mapa)
            startActivity(intent)

        }

        binding.button2.setOnClickListener {
            Toast.makeText(this, "Removendo da lista..", Toast.LENGTH_SHORT).show()
        }

        binding.button3.setOnClickListener {
            val url_mapa = "https://pt.wikipedia.org/wiki/$nome"

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url_mapa)
            startActivity(intent)
        }

        supportActionBar?.title = "$nome"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        /*supportActionBar?.setDisplayHomeAsUpEnabled(true)*/



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id != R.id.action_sair){
            var it = Intent(this, HomeScreenActivity::class.java)
            startActivity(it)
        }

        return true
    }

}