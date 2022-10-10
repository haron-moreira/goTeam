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

        binding.btnLogin.setOnClickListener {
            Toast.makeText(this, "Validando dados...", Toast.LENGTH_SHORT).show()



            /*val params = Bundle()
            *params.putString("usuario", "Haron")
            *params.putString("senha", "senha123")

            *intent.putExtras(params)*/

            val username = binding.campoUsuario.text.toString()
            val senha = binding.campoSenha.text.toString()

            if (username == "aluno" && senha == "impacta"){
                val intent = Intent(this, HomeScreenActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
            }
        }
    }
}