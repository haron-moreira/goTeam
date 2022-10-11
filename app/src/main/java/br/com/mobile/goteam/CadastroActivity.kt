package br.com.mobile.goteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        supportActionBar?.title = "Cadastrar"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


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