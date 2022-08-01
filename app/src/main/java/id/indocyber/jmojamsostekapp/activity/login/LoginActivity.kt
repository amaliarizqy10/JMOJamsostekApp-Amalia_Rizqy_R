package id.indocyber.jmojamsostekapp.activity.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.indocyber.jmojamsostekapp.activity.home.HomeActivity
import id.indocyber.jmojamsostekapp.databinding.LayoutLoginBinding

class LoginActivity : AppCompatActivity() {

        private lateinit var binding: LayoutLoginBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = LayoutLoginBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.button.setOnClickListener {
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }
}