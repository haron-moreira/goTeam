package br.com.mobile.goteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import br.com.mobile.goteam.databinding.ActivitySobreBinding


class SobreActivity : LogActivity() {

    private val binding by lazy {
        ActivitySobreBinding.inflate(layoutInflater)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = "Sobre"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



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