package br.com.mobile.goteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import br.com.mobile.goteam.databinding.ActivityCadastroBinding
import br.com.mobile.goteam.databinding.ActivityHomeScreenBinding
import br.com.mobile.goteam.databinding.LoginActivityBinding
import kotlin.concurrent.timer


class HomeScreenActivity : LogActivity() {

    private val binding by lazy {
        ActivityHomeScreenBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = "Home"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Toast.makeText(this, "Bem Vindo!", Toast.LENGTH_SHORT).show()

       val params = intent.extras

        val nome = params?.getString("nome")
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)

        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView?)?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                //Toast.makeText(this, "Atualizado!", Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

        })
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_sair){
            finish()
            /* val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) */
        } else if (id == R.id.action_atualizar) {

            binding.progressBar.visibility = View.VISIBLE

            Handler(Looper.getMainLooper()).postDelayed(
                {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, "Atualizado!", Toast.LENGTH_SHORT).show()
                }, 10000
            )

        } else if (id == R.id.action_add) {

            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)

        } else if (id == R.id.action_buscar) {

            Toast.makeText(this, "Buscando...", Toast.LENGTH_SHORT).show()

        } else {

            Toast.makeText(this, "Algo está errado...", Toast.LENGTH_SHORT).show()

        }

        return true
    }


}
