package br.com.mobile.goteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
}