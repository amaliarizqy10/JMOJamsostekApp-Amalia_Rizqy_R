package id.indocyber.jmojamsostekapp.activity.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.indocyber.jmojamsostekapp.activity.contact.ContactActivity
import id.indocyber.jmojamsostekapp.activity.home.HomeActivity
import id.indocyber.jmojamsostekapp.activity.news.NewsActivity
import id.indocyber.jmojamsostekapp.databinding.LayoutProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: LayoutProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.news.setOnClickListener {
            startActivity(Intent(this, NewsActivity::class.java))
        }

        binding.contact.setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        }

        binding.home.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}