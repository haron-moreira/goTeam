package br.com.mobile.goteam

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import br.com.mobile.goteam.databinding.ActivityHomeScreenBinding
import com.google.android.material.navigation.NavigationView


class HomeScreenActivity : LogActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this

    private val binding by lazy {
        ActivityHomeScreenBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        Toast.makeText(this, "Bem Vindo!", Toast.LENGTH_SHORT).show()

       val params = intent.extras
        val nome = params?.getString("nome")



        setSupportActionBar(binding.toolbarInclude.toolbar)
        supportActionBar?.title = "Home"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        configMenuLateral()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)



        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView?)?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                Toast.makeText(context, "$newText", Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(context, "$query", Toast.LENGTH_SHORT).show()
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){

            R.id.nav_paises -> {
                Toast.makeText(this, "Clicou em países", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_sobre -> {
                Toast.makeText(this, "Clicou em sobre", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_logout -> {
                finish()
            }
        }

        binding.layoutMenuLateral.closeDrawer(GravityCompat.START)

        return true

    }

    private fun configMenuLateral() {
        var toggle = ActionBarDrawerToggle(this, binding.layoutMenuLateral, binding.toolbarInclude.toolbar, R.string.abrir, R.string.fechar)
        binding.layoutMenuLateral.addDrawerListener(toggle)

        toggle.syncState()

        binding.menuLateral.setNavigationItemSelectedListener(this)
    }


}
