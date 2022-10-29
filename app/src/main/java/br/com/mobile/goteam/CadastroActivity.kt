package br.com.mobile.goteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.com.mobile.goteam.databinding.ActivityCadastroBinding

class CadastroActivity : LogActivity() {

    private val binding by lazy {
        ActivityCadastroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = "Cadastrar"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnCadastra.setOnClickListener {

            val pais = Pais()

            pais.nome = binding.nomePais.text.toString()
            pais.capital = binding.capitalPais.text.toString()
            pais.continente = binding.continentePais.text.toString()
            pais.populacao = binding.populacaoPais.text.toString()
            pais.latitude = binding.latitudePais.text.toString()
            pais.longitude = binding.longitudePais.text.toString()
            pais.bandeira = binding.urlBandeira.text.toString()

            taskPaises(pais)

        }

    }

    private fun taskPaises(pais: Pais) {

        Thread {
            PaisService.savePais(pais)

            runOnUiThread {
                finish()
            }
        }.start()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_sair){
            finish()
            /* val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) */
        } else if (id == R.id.action_atualizar) {


            Toast.makeText(this, "Atualizando...", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_add) {
            Toast.makeText(this, "Você já está nessa tela!", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_buscar) {
            // Não consegui implementar a parte de busca..
            Toast.makeText(this, "Buscando...", Toast.LENGTH_SHORT).show()
            
        } else {
            finish()
        }

        return true
    }

}