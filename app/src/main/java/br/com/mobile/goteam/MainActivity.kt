package br.com.mobile.goteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.mobile.goteam.databinding.LoginActivityBinding


class MainActivity : LogActivity() {

    private val binding by lazy {
        LoginActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = "Login"

        binding.globoLogin.setImageResource(R.drawable.globo80)
        val nomeUsuario = Prefs.getString("nomeUsuario")
        val senhaUsuario = Prefs.getString("senhaUsuario")
        val checkLogin = Prefs.getBoolean("checkLogin")

        if (nomeUsuario.equals("")) {
            Toast.makeText(this, "Olá! Seja bem-vindo.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "É bom ter você de volta, $nomeUsuario", Toast.LENGTH_SHORT).show()
        }

        binding.campoUsuario.setText(nomeUsuario)
        binding.campoSenha.setText(senhaUsuario)
        binding.lembrarUsuario.isChecked = checkLogin

        binding.btnLogin.setOnClickListener {

            /*val params = Bundle()
            *params.putString("usuario", "Haron")
            *params.putString("senha", "senha123")

            *intent.putExtras(params)*/

            val username = binding.campoUsuario.text.toString()
            val senha = binding.campoSenha.text.toString()

            if (binding.lembrarUsuario.isChecked) {
                Prefs.setString("nomeUsuario", username)
                Prefs.setString("senhaUsuario", senha)
            } else {
                Prefs.setString("nomeUsuario", "")
                Prefs.setString("senhaUsuario", "")
            }

            Prefs.setBoolean("checkLogin", binding.lembrarUsuario.isChecked)

            if (username == "aluno" && senha == "impacta"){
                val intent = Intent(this, HomeScreenActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
            }
        }
    }
}